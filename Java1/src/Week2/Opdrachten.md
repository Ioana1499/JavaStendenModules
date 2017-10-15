Opdracht 2.1
Nothing, after the ticket is printed the balance is reset to zero.
	
Opdracht 2.2
It will always print the ticket no matter what amount of money you put in the ticket machine.

Opdracht 2.3
-
Opdracht 2.4
-
Opdracht 2.5
construct Student( String name );
String Student.getName();
void Student.setName( String name );
String Student.getCode();
void Student.setCode( String code );

construct LabClass( int allowedAmountOfStudents );
void LabClass.setName( String name );
Srting LabClass.getName();
int LabClass.getAmountOfStudents();
void LabClass.setAmountOfStudents();
String LabClass.getStudentList();
void LabClass.setStudent( Student student );
Student LabClass.getStudent( studentCode );

Opdracht 2.6
It is possible.

Opdracht 2.7
Not possible.

Opdracht 2.8
public class TicketMachine
{
    property price;
    property balance
    propetry total

    constructor TicketMachine(int cost)
    method getPrice()

    method getBalance()
 
    method insertMoney(int amount)
   
    Method printTicket()
}

Opdracht 2.9
It is the first method that always will be called when initiating an new object from the class.

Opdracht 2.10
private int count; - Integer
private Student representative; - Student Object
private Server host; - Server Object

Opdracht 2.11
private boolean alive; - alive
private Person tutor; - tutor
private Game game; - game

Opdracht 2.12
Student and Server

Opdracht 2.13
Yes it matters.

Opdracht 2.14
Yes.

Opdracht 2.15
private int status;

Opdracht 2.18
Student class

Opdracht 2.19
2 and the first one is an string and the second one an dubble

Opdracht 2.20
string's
Author objects

Opdracht 2.21
public Pet( String petsName )
{
	name = petsName;
	// Or
	Pet.name = petsName;
}

Opdracht 2.22
public Date( String month, int day, int year ) 
{
	this.month = month;
	this.day = day;
	this.year = year;
} 

Opdracht 2.23
They return diffrent properties.

Opdracht 2.24
How much money did I insert?

Opdracht 2.25
Nope.

Opdracht 2.26
public int getTotal()
{
	return total;
}

Opdracht 2.27
Missing return statement.

Opdracht 2.28
One is an simple getter and the other one outputs data and modifies the objects properties.

Opdracht 2.29
No because they modify the object and don't have to return anything.

Opdracht 2.30
-
Opdracht 2.31
Because of its return type.

Opdracht 2.32
public void setPrice( int cost )
{
	price = cost;
}

Opdracht 2.33
public void increase( int points )
{
	score += points;
}

Opdracht 2.34
Yes because it modifies the state of the object.

Opdracht 2.35
public void discount( int amount )
{
	price -= amount;
}

Opdracht 2.36
My cat has green eyes.

Opdracht 2.37
public void prompt()
{
	System.out.println("Please insert the correct amount of money.");
}

Opdracht 2.38
Then it would output the string price and not the property.

Opdracht 2.39
It would output the string # price cents.

Opdracht 2.40
Nope because java interpets it as an string and not as an variable.

Opdracht 2.41
public void showPrice( )
{
	System.out.println( "The price of a ticket is " + price + " cents.");
}

Opdracht 2.42
They differ because they are difrent instances of the class and the properties are not static defined.

Opdracht 2.43
public TicketMachine()
{
	price = 1000;
	balance = 0;
	total = 0;
}

Opdracht 2.44
public TicketMachine( int price )
{
	TicketMachine.price = price;
	balance = 0;
	total = 0;
}
public TicketMachine()
{
	price = 1000;
	balance = 0;
	total = 0;
}

Opdracht 2.45
public void empty()
{
	total = 0;
}
Opdracht 2.46
Then the message will also be printed because it checks for an value that is greater than 0.

Opdracht 2.47
Then it will also accept the insertion of 0.

Opdracht 2.48
-

Opdracht 2.49
Is vissable, jep because the vissabilaty onley has 2 states.

Opdracht 2.50
Now it isn't possible to print tickets when the user hasnt insterted enough money.

Opdracht 2.51
Yes, the ticket machine will not print an error message that you didn't insert enough money.

Opdracht 2.52
Yes, when you initiate the ticket machine with an negative price.

Opdracht 2.53
You also got:
+ Additive operator
- Subtraction operator
* Multiplication operator
/ Division operator
% Remainder operator

Opdracht 2.54
public void calcDiscountSavings()
{
	savings = price - discount;
}

Opdracht 2.55
public void calcMean()
{
	mean = total / count;
}

Opdracht 2.56
public void checkBuget()
{
	if( price > buget )
	{
		System.out.println( "Too expencive" );
	}
	else
	{
		System.out.println( "Just right" );
	}
}

Opdracht 2.57
public void checkBuget()
{
	if( price > budget )
	{
		System.out.println( "Too expencive your budget is: " + budget );
	}
	else
	{
		System.out.println( "Just right" );
	}
}

Opdracht 2.58
It sets the balance to zero.

Opdracht 2.59
You get an compiler error because it is an unreachable statment.

Opdracht 2.60
The price is redefined in an local scope. If you want to save the price
you have to use this.price if you want to set the property of the object.

Opdracht 2.61
public int emptyMachine()
{
	refund = total;
	total = 0;
	return refund;
}

Opdracht 2.62
public void printTicket()
{
	int amountLeftToPay = price - balance;

	if( amountLeftToPay < 0 ) 
	{
		// Simulate the printing of a ticket.
		System.out.println("##################");
		System.out.println("# The BlueJ Line");
		System.out.println("# Ticket");
		System.out.println("# " + price + " cents.");
		System.out.println("##################");
		System.out.println();
		// Update the total collected with the price.
		total = total + price;
		// Reduce the balance by the price.
		balance = balance - price;
	}
	else 
	{
		System.out.println("You must insert at least: " + amountLeftToPay + " more cents."); 
	}   
}

Opdracht 2.63
void setDiscountPrice( int discountPrice );
void printAvailableDiscounts();
And the print ticket should be rewritten.

Opdracht 2.64
name: getCode
return type: String

Opdracht 2.65
name: creditValue
type: integer

Opdracht 2.66
public class Person { }

Opdracht 2.67
public class Person 
{
	private String name;
	private int age;
	private String code;
	private int credits; 
}

Opdracht 2.68
public class Module 
{
	public String code;

	public Module( String moduleCode )
	{
		code = moduleCode;		
	}
}

Opdracht 2.69
public class Person 
{
	private String name;
	private int age;
	private String code;
	private int credits; 

	public Person( String myName, int myAge )
	{
		name = myName;
		age = myAge;
	}
}

Opdracht 2.70
It should be:
public int getAge()
{ 
	return age;
}

Opdracht 2.71
public String getName()
{ 
	return name;
}

Opdracht 2.72
public void setAge( int age )
{ 
	this.age = age;
}

Opdracht 2.73
public void printDetails()
{
	System.out.println( "The name of this person is: + name );
}

Opdracht 2.74
done;

Opdracht 2.75
Henr557

Opdracht 2.76
You will get an error that the string index is out of range.

Opdracht 2.77
public Student(String fullName, String studentID)
{
	if( fullName.length() < 4 )
	{
		throw new IllegalArgumentException( "You shall not instantiate this class" );
	}

	name = fullName;
	id = studentID;
	credits = 0;
}

Opdracht 2.78
public String getLoginName()
{
	if( name.length < 4 )
	{
		return name.substring( 0, name.length() ) + id.substring( 0,3 );
	}

	return name.substring( 0, 4 ) + id.substring(0,3);
}

Opdracht 2.79
102
catfish
cat9
12cat
f
an index out of bound exception.

Opdracht 2.80
0 and 500

Opdracht 2.81
500

Opdracht 2.82
It will return 1000 because t2 points to t1.

Opdracht 2.83
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle )
    {
        author = bookAuthor;
        title = bookTitle;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }
}

Opdracht 2.84
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle )
    {
        author = bookAuthor;
        title = bookTitle;
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
}

Opdracht 2.85
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
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
}

Yes because you cannot set any propertys after initiation.

Opdracht 2.86
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
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
        System.out.println( "Title " + title + ", Author: " + author + ", Pages: " + pages );
    }
}

Opdracht 2.87
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages, String refNumber )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = refNumber;
    }

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = "";
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
        System.out.println( "Title " + title + ", Author: " + author + ", Pages: " + pages );
    }
}

Opdracht 2.88
/**
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

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages, String refNumber )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = refNumber;
    }

    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book( String bookAuthor, String bookTitle, int pages )
    {
        author = bookAuthor;
        title = bookTitle;
        this.pages = pages;
        this.refNumber = "";
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
        System.out.println( "Title " + title + ", Author: " + author + ", Pages: " + pages + 
		", reference number: " + (refNumber.length() > 0 ? refNumber : "ZZZ" ) );
    }
}
Opdracht 2.89
public void setRefNumber( String newRefnumber )
{
	if( newRefnumber.length() < 3 )
	{
	    throw new IllegalArgumentException( "The refrence number must be atleast 3 chars" );
	}
	refNumber = newRefnumber;
}

Opdracht 2.90/2.91

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







