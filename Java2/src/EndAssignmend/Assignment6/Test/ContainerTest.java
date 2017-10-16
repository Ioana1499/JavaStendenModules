package Assignment6.Test;

import Assignment6.Main1.Container;
import Assignment6.Main1.FullContainerException;
import org.junit.Test;

import static junit.framework.Assert.*;

public class ContainerTest
{
    @Test
    public void testInitiateContainer()
    {
        Container container = new Container();
        assertEquals( "The container returned an invalid default size", 12, container.getSizeM2() );
        assertEquals( "The container returned an invalid default size", 24, container.getSizeM3() );
        container = new Container( 2, 2, 3 );
        assertEquals( "The container returned an invalid size", 6, container.getSizeM2() );
        assertEquals( "The container returned an invalid size", 12, container.getSizeM3() );
    }

    @Test
    public void testStoreItems0()
    {
        boolean exception = false;
        Container container = new Container( 1, 2, 3 );
        try
        {
            container.addContent( 40000 );
        }
        catch( FullContainerException ex )
        {
            exception = true;
        }
        assertTrue( "Error no exception was thrown when overloading container",exception );
    }

    @Test
    public void testStoreItems1()
    {
        boolean exception = false;
        Container container = new Container( 1, 2, 3 );
        try
        {
            container.addContent( 7 );
        }
        catch( FullContainerException ex )
        {
            exception = true;
        }
        assertTrue( "Error no exception was thrown when overloading container",exception );
    }

    @Test
    public void testStoreItems2()
    {
        boolean exception = true;
        Container container = new Container( 1, 2, 3 );
        try
        {
            container.addContent( 6 );
        }
        catch( FullContainerException ex )
        {
            exception = true;
        }
        assertTrue( "Error no exception was thrown when overloading container",exception );
    }

    @Test
    public void testSize()
    {
        Container container = new Container( 10, 10, 10 );
        assertEquals( String.format( "Wrong container m3 size: %d expected 1000 quebec meter.", container.getSizeM3()),
                1000,
                container.getSizeM3()
        );
        assertEquals( String.format( "Wrong container m2 size: %d expected 100 square meter.", container.getSizeM2()),
                100,
                container.getSizeM2()
        );
    }

    @Test
    public void testIsAbleToStore()
    {
        Container container = new Container( 10, 10,10 );
        assertFalse( String.format( "Should not be able to store %s in container with m3 size of 1000", 1300 ),
                container.isAbleToStore( 1300 )
        );
        assertFalse( String.format( "Should not be able to store %s in container with m3 size of 1000", 1001 ),
                container.isAbleToStore( 1001 )
        );
        assertTrue( String.format( "Should not be able to store %s in container with m3 size of 1000", 1000 ),
                container.isAbleToStore( 1000 )
        );
    }
}
