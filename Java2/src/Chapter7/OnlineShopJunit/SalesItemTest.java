package OnlineShopJunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        assertEquals( true, salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 4 ) );
        assertEquals( 1, salesIte1.getNumberOfComments() );
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem( "Java For Complete Idiots, Vol 2", 19900 );
        assertEquals( false, salesIte1.addComment( "Joshua Black", "Not worth the money. The font is too small.", -5 ) );
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem( "test name", 1000 );
        assertEquals( "test name", salesIte1.getName() );
        assertEquals( 1000, salesIte1.getPrice() );
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testShowInfo()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 4 );
        salesIte1.showInfo();
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testNumberOfComments()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 4 );
        assertEquals( 1, salesIte1.getNumberOfComments() );
    }

    @Test
    public void testRejectSameAuthor()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 4 );
        assertEquals( false, salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 4 ) );
    }

    @Test
    public void testBoundary()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        assertEquals( false, salesIte1.addComment( "James Duckling", "This book is great. I learned all my Java from it.", 10 ));
        assertEquals( false, salesIte1.addComment( "Bob Duckling", "This book is great. I learned all my Java from it.", -1 ));
    }

    @Test
    public void testUpVote()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "James", "This book is great. I learned all my Java from it.", 5 );
        salesIte1.addComment( "Bob", "This book is great. I learned all my Java from it.", 2 );
        salesIte1.addComment( "Alice", "This book is great. I learned all my Java from it.", 4 );
        salesIte1.upvoteComment( 0 );
        salesIte1.upvoteComment( 0 );
        assertEquals( "James", salesIte1.findMostHelpfulComment().getAuthor() );
    }

    @Test
    public void testDownVote()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "James", "This book is great. I learned all my Java from it.", 5 );
        salesIte1.addComment( "Bob", "This book is great. I learned all my Java from it.", 2 );
        salesIte1.addComment( "Alice", "This book is great. I learned all my Java from it.", 4 );
        salesIte1.upvoteComment( 0 );
        salesIte1.upvoteComment( 1 );
        salesIte1.upvoteComment( 2 );
        salesIte1.downvoteComment( 0 );
        salesIte1.downvoteComment( 1 );
        assertEquals( "Alice", salesIte1.findMostHelpfulComment().getAuthor() );
    }

    @Test
    public void testMostUsefullComment()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        assertNull( salesIte1.findMostHelpfulComment() );
    }

    @Test
    public void testAssignment715()
    {
        SalesItem item = new SalesItem( "box", 10 );
        assertEquals( false, item.addComment( "bob", "text", 0 ) );
        assertEquals( false, item.addComment( "alice", "text", 6 ) );
    }

    @Test
    public void testAssignment716()
    {
        SalesItem item = new SalesItem( "box", 10 );
        item.addComment( "bob", "text", 1 );
        assertEquals( false, item.addComment( "bob", "text", 1 ) );
    }

    @Test
    public void testAssignment719()
    {
        SalesItem salesIte1 = new SalesItem( "Java for complete Idiots", 21998 );
        salesIte1.addComment( "bob", "This book is great. I learned all my Java from it.", 5 );
        salesIte1.addComment( "alice", "This book is great. I learned all my Java from it.", 2 );

        salesIte1.upvoteComment( 0 );
        salesIte1.upvoteComment( 0 );

        assertEquals( "bob", salesIte1.findMostHelpfulComment().getAuthor() );
    }


}


