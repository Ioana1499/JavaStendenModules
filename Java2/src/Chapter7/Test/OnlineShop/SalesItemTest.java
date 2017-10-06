package Test.OnlineShop;

import OnlineShopJunit.SalesItem;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalesItemTest
{

    @Test
    public void sailsItemTest()
    {
        SalesItem salesItem = new SalesItem( "Box", 10 );
        salesItem.addComment( "Hello world", "hello 1", 10 );
        salesItem.addComment( "Hello world", "hello 2", 10 );
        salesItem.addComment( "Hello world", "hello 3", 10 );
        salesItem.addComment( "Hello world", "hello 4", 10 );

        assertEquals( 4, salesItem.getNumberOfComments() );
    }
}
