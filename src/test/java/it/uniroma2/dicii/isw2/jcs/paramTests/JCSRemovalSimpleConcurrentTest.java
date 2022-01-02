package it.uniroma2.dicii.isw2.jcs.paramTests;

import org.apache.jcs.JCS;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class JCSRemovalSimpleConcurrentTest {

    private JCS jcs;

    @Before
    public void configure() throws Exception {
        JCS.setConfigFilename( "/TestRemoval.ccf" );
        this.jcs = JCS.getInstance( "testCache1" );
    }

    @Test
    public void testTwoDeepRemoval() throws Exception {
        System.out.println( "------------------------------------------" );
        System.out.println( "testTwoDeepRemoval" );

        int count = 500;

        for ( int i = 0; i <= count; i++ )
        {
            jcs.put( "key:" + i + ":anotherpart", "data" + i );
        }

        for ( int i = count; i >= 0; i-- )
        {
            String res = (String) jcs.get( "key:" + i + ":anotherpart" );
            if ( res == null )
            {
                assertNotNull( "[key:" + i + ":anotherpart] should not be null, " + jcs.getStats(), res );
            }
        }
        System.out.println( "Confirmed that " + count + " items could be found" );

        for ( int i = 0; i <= count; i++ )
        {
            jcs.remove( "key:" + i + ":" );
            assertNull( jcs.getStats(), jcs.get( "key:" + i + ":anotherpart" ) );
        }
        System.out.println( "Confirmed that " + count + " items were removed" );

        System.out.println( jcs.getStats() );
    }
}
