package Assignment6.Test;

import Assignment6.Main.Container;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ContainerTest
{
    @Test
    public void testInitiateContainer()
    {
        Container container = new Container( );
        assertEquals( "The container returned an invalid default size",  12, container.getSizeM2() );
        assertEquals( "The container returned an invalid default size",  24, container.getSizeM3() );
        container = new Container( 2, 2,3 );
        assertEquals( "The container returned an invalid size", 6 , container.getSizeM2() );
        assertEquals( "The container returned an invalid size", 12 , container.getSizeM3() );
        container = new Container(   )
        assertEquals( "The container returned an invalid default size",  12, container.getSize() );

    }
}
