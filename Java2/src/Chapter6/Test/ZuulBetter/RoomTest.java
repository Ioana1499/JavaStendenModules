package Test.ZuulBetter;

import ZuulBetter.Room;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RoomTest
{
    @Test
    public void TestInitiation ()
    {
        Room room = new Room( "test" );
        assertEquals( "Room cannot be initiated...", "test", room.getShortDescription() );
    }
}
