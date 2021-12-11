package it.francescodecaro;

import org.apache.jcs.JCS;
import org.apache.jcs.engine.behavior.ICacheElement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class JCSCacheElementRetrievalUnitTest {

    private JCS jcs;
    private long time;
    private String key;
    private String data;

    @Parameters
    public static Collection<Object[]> configure() throws Exception {
        JCS jcs = JCS.getInstance( "testCache1" );

        Object[][] elems = new Object[][] {
                { jcs, 0, "test_key", "test_data"},
                { jcs, 0, "test_key2", "test_data2" },
                { jcs, 0, "test_key3", "test_data3"}
        };

        for (Object[] elem : elems) {
            jcs.put(elem[2], elem[3]);
            elem[1] = System.currentTimeMillis();
        }

        return Arrays.asList(elems);
    }

    public JCSCacheElementRetrievalUnitTest(JCS jcs, long time, String key, String data) {
        this.jcs = jcs;
        this.time = time;
        this.key = key;
        this.data = data;
    }

    /**
     *
     * @throws Exception
     */
    @Test
    public void testSimpleElementRetrieval()
            throws Exception
    {
        // System.out.println(this.jcs + "; " + this.time + "; " + this.key + "; " + this.data);
        ICacheElement elem = jcs.getCacheElement( this.key );
        assertEquals( "Name wasn't right", "testCache1", elem.getCacheName() );

        long diff = this.time - elem.getElementAttributes().getCreateTime();
        assertTrue( "Create time should have been at or after the call", diff >= 0 );
    }
}
