package OnlineShop;

import junit.framework.TestSuite;
import org.junit.Test;

import static junit.framework.Assert.*;

public class OnlineShopTest
{
    public static void main ( String[] args )
    {

    }

    @Test
    public void addCommentsTest ()
    {
        SalesItem salesItem = new SalesItem( "book", 10 );
        salesItem.addComment( "Joris", "Hey cool book", 10 );
        salesItem.addComment( "Bob", "Cool book I should tell alice about it.", 10 );
        salesItem.addComment( "Alice", "Cool book but I cant decrypt it.", 10 );
        salesItem.addComment( "EliotAnderson", "F*ck society", 10 );
        System.out.println( salesItem.getNumberOfComments() );

        String errorMessage = String.format( "%s error: Incorrect number of comments are available", OnlineShopTest.class.getSimpleName());
        assertEquals( errorMessage, 4, salesItem.getNumberOfComments() );
    }
}
