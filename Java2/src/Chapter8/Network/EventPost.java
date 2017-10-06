package Network;

import java.util.Date;

public class EventPost extends Post
{
    private Date eventDate;
    private String eventName;

    /**
     * Initiate an new event post.
     *
     * @param author  The username of the author of this post.
     * @param eventName The name of the event.
     * @param eventDate The date of the event.
     */
    public EventPost(String author, String eventName, Date eventDate )
    {
        super(author);
        this.eventDate = eventDate;
        this.eventName = eventName;
    }

    /**
     * Display the details of this post.
     * (Currently: Print to the text terminal. This is simulating display
     * in a web browser for now.)
     */
    @Override
    public void display()
    {
        printTitle( "EventName: \t" + eventName );
        System.out.println( eventDate.toString() );
        printTrentData();
    }

    /**
     * Prints an short summary of the post.
     */
    @Override
    public void printShortSummary()
    {
        System.out.println( String.format( "Message post from %s", getUsername() ) );
    }
}
