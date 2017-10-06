 /*
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today’s date here.)
 */
public class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private boolean courseText;
    private int borrowed;

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages, boolean courseText, String refNumber )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = refNumber;
        this.courseText = courseText;
    }

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, boolean courseText, int pages )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = "";
        this.courseText = courseText;
    }

    public void borrow()
    {
        borrowed ++;
    }

    public int getBorrowed()
    {
        return borrowed;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void printAuthor()
    {
        System.out.println( author );
    }

    public void printTitle()
    {
        System.out.println( title );
    }

    public void printDetails()
    {
        System.out.println( "Title " + title + ", Author: " + author + ", Pages: " + pages + (refNumber.length() > 0 ? ", reference number: " + refNumber : "" ) );
    }

    public void setRefNumber( String newRefnumber )
    {
        if( newRefnumber.length() < 3 )
        {
            throw new IllegalArgumentException( "The refrence number must be atleast 3 chars" );
        }
        refNumber = newRefnumber;
    }


}