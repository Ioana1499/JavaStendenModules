package Network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public abstract class Post
{
    protected String username;  // username of the post's author
    protected long timestamp;
    protected int likes;
    protected ArrayList<String> comments;

    public static BiFunction<Integer, String, String> stringRepeat = ( n, string ) -> Collections.nCopies( n, string ).stream().collect( Collectors.joining( "" ) );

    public static void printTitle( String title )
    {
        System.out.println( String.format( "%2$s\n %s\t\t\t\n%2$s", title, stringRepeat.apply( 80, "=" ) ) );
    }

    /**
     * Initiates an post.
     *
     * @param username The author of the post.
     */
    Post( String username )
    {
        this.username = username;
        this.timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<String>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if( likes > 0 )
        {
            likes--;
        }
    }

    /**
     * Add a comment to this post.
     *
     * @param text The new comment to add.
     */
    public void addComment( String text )
    {
        comments.add( text );
    }

    /**
     * Return the time of creation of this post.
     *
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }

    /**
     * Display the details of this post.
     * (Currently: Print to the text terminal. This is simulating display
     * in a web browser for now.)
     */
    public abstract void display();

    /**
     * Prints an short summary of the post.
     */
    public abstract void printShortSummary();

    /**
     * Create a string describing a time point in the past in terms
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     *
     * @param time The time value to convert (in system milliseconds)
     * @return A relative time string for the given time
     */
    protected String timeString( long time )
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;
        if( minutes > 0 )
        {
            return minutes + " minutes ago";
        }
        else
        {
            return seconds + " seconds ago";
        }
    }

    /**
     * Print data about the likes and comments.
     */
    protected void printTrentData()
    {
        System.out.print( timeString( timestamp ) );
        System.out.println( likes == 0 ? "" : String.format( "\t-\t%s people like this.", this.likes ) );
        System.out.println( comments.isEmpty() ? "\tNo comments" : String.format( "\t %s comment(s). Click here to view.", comments.size() ) );
        System.out.println();
    }

    /**
     * Getter for property 'username'.
     *
     * @return Value for property 'username'.
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * Setter for property 'username'.
     *
     * @param username Value to set for property 'username'.
     */
    public void setUsername( String username )
    {
        this.username = username;
    }

    /**
     * Getter for property 'likes'.
     *
     * @return Value for property 'likes'.
     */
    public int getLikes()
    {
        return likes;
    }

    /**
     * Setter for property 'likes'.
     *
     * @param likes Value to set for property 'likes'.
     */
    public void setLikes( int likes )
    {
        this.likes = likes;
    }
}
