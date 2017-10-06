// Opdracht 4.1
/**
 *  Yes, works
 */

// Opdracht 4.2
/**
 * Nothing
 */

// Opdracht 4.3
/**
 * Then the List shifts the indexes.
 */

// Opdracht 4.4
import java.util.ArrayList;
/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    private ArrayList<Book> library;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}

// Opdracht 4.5
/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    private ArrayList<Book> library;
    private ArrayList<Student> cs101;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}

// Opdracht 4.6
/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    private ArrayList<Book> library;
    private ArrayList<Student> cs101;
    private ArrayList<MusicTrack> tracks;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}

// Opdracht 4.7
/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files = new ArrayList<>();
    private ArrayList<Book> library = new ArrayList<Book>();
    private ArrayList<Student> cs101 = new ArrayList<>();
    private ArrayList<MusicTrack> new ArrayList<>();

    public void addFile( String file )
    {
        files.add( file );
    }

    public void addBook( Book book )
    {
        library[] = book;
    }

    public void addStudent( Student student )
    {
        cs101.add( student );
    }

    public void addTrack( MusicTrack track )
    {
        tracks.add( track );
    }

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}

// Opdracht 4.8
// 10

// Opdracht 4.9
// items.get( 4 );

// Opdracht 4.10
// 14

// Opdracht 4.11
// files.add( favoriteTrack );

// Opdracht 4.12
// dates.remove( 2 );

// Opdracht 4.13
// 5

// Opdracht 4.14
public boolean checkIndex( int index )
{
    return ( files[ index ] == 0 );
}

// Opdracht 4.15
public boolean validateIndex( int index )
{
    
}

// Opdracht 4.16
/**
 *
 */

// Opdracht 4.17
/**
 *
 */
// Opdracht 4.18
public void listAllFiles( );

// Opdracht 4.19
/**
 * One
 */
for( File file : files )
{
    System.out.println( file.getName() )
}

// Opdracht 4.20
/**
 * A class to hold details of audio files.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files = new ArrayList<>();
    private ArrayList<Book> library = new ArrayList<Book>();
    private ArrayList<Student> cs101 = new ArrayList<>();
    private ArrayList<MusicTrack> new ArrayList<>();

    public void listAllFiles( )
    {
        for( File file : files )
        {
            System.out.println( file.getName() )
        }
    }

    public void addFile( String file )
    {
        files.add( file );
    }

    public void addBook( Book book )
    {
        library[] = book;
    }

    public void addStudent( Student student )
    {
        cs101.add( student );
    }

    public void addTrack( MusicTrack track )
    {
        tracks.add( track );
    }

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }
}

// Opdracht 4.21
/**
 * Done, and it works
 */
// Opdracht 4.22
/**
 * Done, I created an ArrayList and called some of its methods.
 */

// Opdracht 4.23
/**
 * Done, set an breakpoint on the for loop and steped through the iterations.
 */

/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Assingments done in bluej
 */
// Opdracht 4.25
/**
 * Done see Opdracht_4.25 in this dir for the assignment.
 */
// Opdracht 4.27
/**
 * Done see Opdracht_4.27 in this directory for the assignment.
 */
// Opdracht 4.28
/**
 * Done see Opdracht_4.28
 */

// Opdracht 4.29
for( Track track : Tracks )

// Opdracht 4.30
boolean missing = true;
while(missing) {
    if(the keys are in the next place) {
        missing = false;
    }
}

boolean found = false;
while( !found ) {
    if(the keys are in the next place) {
        found = true;
    }
}
// Opdracht 4.31
/**
 * Write a while loop (for example, in a method called multiplesOfFive)
 that prints out all multiples of 5 between 10 and 95.
 */
void multiplesOfFive()
{
        int iterationCount = 0;
        while( iterationCount < 94 )
        {
            if( iterationCount % 5 == 0 )
            {
                System.out.println( iterationCount )
            }
            iterationCount++;
        }
}
// Opdracht 4.32
/**
 * Write a method called sum with a while loop that adds up all numbers be-
 * tween two numbers a and b. The values for a and b can be passed to the sum method as
 * parameters.
 */
int sum( int a, int b )
{
        int sum 0;
        int iterationThing = a;

        while( iterationThing <= b )
        {
            sum += a
            iterationThing++;
        }
        return sum;
}

// Opdracht 4.34
/**
 * Done see Opdracht_4.34 in this directory for the assignment.
 */

// Opdracht 4.35
/**
 * Done see Opdracht_4.35 in this directory for the assignment.
 */
// Opdracht 4.36
/**
 * Done see Opdracht_4.35 in this directory for the assignment.
 */

// Opdracht 4.37
/**
 * Done see Opdracht_4.37 in this directory for the assignment.
 */

// Opdracht 4.38
/**
 * Done see Opdracht_4.38 in this directory for the assignment.
 */

// Opdracht 4.39
/**
 * Done see Opdracht_4.39 in this directory for the assignment.
 */

// Opdracht 4.40
/**
 * Done see Opdracht_4.40 in this directory for the assignment.
 */

// Opdracht 4.41
/**
 * Done see Opdracht_4.41 in this directory for the assignment.
 */

// Opdracht 4.42
/**
 * Done see Opdracht_4.42 in this directory for the assignment.
 */

// Opdracht 4.46
/**
 * Done see Opdracht_4.46 in this directory for the assignment.
 */

// Opdracht 4.47
/**
 * Done see Opdracht_4.47 in this directory for the assignment.
 */

// Opdracht 4.48
/**
 * Done see Opdracht_4.48 in this directory for the assignment.
 */

// Opdracht 4.49
/**
 * Done see Opdracht_4.49 in this directory for the assignment.
 */

// Opdracht 4.50
/**
 * An internal error will occure with the message:
 * Internal error: Lot number " + selectedLot.getNumber() + " was returned instead of " + lotNumber
 */

// Opdracht 4.51
/**
 * Done see Opdracht_4.51 in this directory for the assignment.
 */

// Opdracht 4.52
/**
 * Done see Opdracht_4.51 in this directory for the assignment.
 */

// Opdracht 4.53
/**
 * FIND INFO ABOUT LISTS
 *
 * ArrayList
 * An array list uses an dynamic array to store its data, if the underlying array is almost full it creates an
 * new array that is 1.5 the size of the origional array and copies the old array into the new one.
 * Because of this mechanism the Array list is faster in storing and accessing data.
 *
 * LinkedList
 * An linked list uses an duble linked list to store data so every element holds the address of the previous
 * and next element in the chain.
 * Because of this mechanism the Linked list is faster at munipulating data.
 *
 * Array
 * An array reserves an (n) size of memmory and you can access that memory by the elements index. It is
 * fast in reading and writing data but slow at inserting data because it has to shift all the elements to an
 * other index.
 */


// Opdracht 4.54
/**
 * Done see Opdracht_4.54 in this directory for the assignment.
 */

// Opdracht 4.55
/**
 * Done see Opdracht_4.55 in this directory for the assignment.
 */

// Opdracht 4.56
/**
 * Done see Opdracht_4.56 in this directory for the assignment.
 */

// Opdracht 4.57
/**
 * Done see Opdracht_4.57 in this directory for the assignment.
 */

// Opdracht 4.58
/**
 * Done see Opdracht_4.58 in this directory for the assignment.
 */

// Opdracht 4.59
/**
 * Done see Opdracht_4.59 in this directory for the assignment.
 */

// Opdracht 4.61
/**
 * LogAnalyzer assignment!
 * Hour 18
 */

// Opdracht 4.62
People[] people = new People[10];

// Opdracht 4.63
boolean[] vacant = new boolean[10];

// Opdracht 4.64
/**
 * LogAnalyzer assignment!
 * 13 times
 */

// Opdracht 4.65
/**
 * Cant find the project?
 */

// Opdracht 4.66
int[] counts = int[];
boolean[] occupied = boolean[5000];

// Opdracht 4.67
/**
 * How many String objects are created by the following declaration?
 * String[] labels = new String[20];
 * Answer: 20
 */

// Opdracht 4.68
/**
 * What is wrong with the following array creation? Correct it.
 * double[] prices = new double(50);
 * Answer: wrong brackets.
 */
// Opdracht 4.69
/**
 * LogAnalyzer assignment!
 * Then is will iterate 1 element to far.
 */

// Opdracht 4.70
/**
 * LogAnalyzer assignment!
 * Done see Opdracht_4.70 in this directory for the assignment.
 */

// Opdracht 4.71
/**
 * Print all the values in the marks array that are
 * greater than mean.
 * @param marks An array of mark values.
 * @param mean The mean (average) mark.
 */
public void printGreater(double[] marks, double[] mean)
{
    for(index = 0; index <= marks.length; index++)
    {
        if(marks[index] > mean)
        {
            System.out.println(marks[index]);
        }
    }
}

// Opdracht 4.72
/**
 * LogAnalyzer assignment!
 * Done see Opdracht_4.72 in this directory for the assignment.
 */

// Opdracht 4.73
/**
 * LogAnalyzer assignment!
 * Done see Opdracht_4.73 in this directory for the assignment.
 */
// Opdracht 4.74
/**
 * LogAnalyzer assignment!
 * Yep works.
 */

// Opdracht 4.75
/**
 * LogAnalyzer assignment!
 * Done see Opdracht_4.75 in this directory for the assignment.
 */

// Opdracht 4.76
/**
 * LogAnalyzer assignment!
 * Done see Opdracht_4.76 in this directory for the assignment.
 */

// Opdracht 4.77
/**
 * LogAnalyzer assignment!
 * The first one because it checks if the new element is les than the previous hightes one so if
 * the last one is 10 the new element 10 is not les than but equal to the previous one.
 */

/**
 * Eind opdracht : 10
 */

