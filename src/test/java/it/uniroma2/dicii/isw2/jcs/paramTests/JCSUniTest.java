package it.uniroma2.dicii.isw2.jcs.paramTests;

import org.apache.jcs.JCS;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.*;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JCSUniTest {

    private static Random random = new Random();
    private JCS jcs;
    private LinkedList list;
    private String key;


    @Parameters
    public static Collection<Object[]> configure() throws Exception {
        JCS jcs = JCS.getInstance( "testCache1" );

        Object[][] elems = new Object[][] {
                { jcs, buildList(), "some:key" },
                { jcs, buildList(), "some:key2" },
                { jcs, buildList(), "some:key3" }
        };

        for (Object[] elem : elems) {
            jcs.put(elem[2], elem[1]);
        }

        return Arrays.asList(elems);
    }

    public JCSUniTest(JCS jcs, LinkedList list, String key) {
        this.jcs = jcs;
        this.list = list;
        this.key = key;
    }

    /**
     * @throws Exception
     */
    @Test
    public void testJCS()
    {
        assertEquals( list, jcs.get( key ) );
    }

    private static LinkedList buildList()
    {
        LinkedList list = new LinkedList();

        for ( int i = 0; i < 100; i++ )
        {
            list.add( buildMap() );
        }

        return list;
    }

    private static HashMap buildMap()
    {
        HashMap map = new HashMap();

        byte[] keyBytes = new byte[32];
        byte[] valBytes = new byte[128];

        for ( int i = 0; i < 10; i++ )
        {
            random.nextBytes( keyBytes );
            random.nextBytes( valBytes );

            map.put( new String( keyBytes ), new String( valBytes ) );
        }

        return map;
    }
}
