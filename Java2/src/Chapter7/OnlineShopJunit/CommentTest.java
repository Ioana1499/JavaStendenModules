package OnlineShopJunit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommentTest
{
    @Test
    public void assignment718Test()
    {
        Comment comment = new Comment( "bob", "text", 1 );
        assertEquals( "bob", comment.getAuthor() );
        assertEquals( 1, comment.getRating() );
    }
}
