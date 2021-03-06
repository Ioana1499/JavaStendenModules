package Excersize1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 13:51
 * License: GPLv3 - General Public License version 3
 */
public class Main
{
    private static List<Person> people = new ArrayList<>( asList(
            new Person( "Joris", "Rietveld", 22 ),
            new Person( "Alice", "sender", 42 ),
            new Person( "Bob", "Receiver", 34 ),
            new Person( "Eve", "Hacker", 12 )
    ));

    public static void sortPeople0()
    {
        Collections.sort( people, new Comparator<Person>(){
            @Override
            public int compare( Person o1, Person o2 )
            {
                return o1.getLastName().compareTo( o2.getLastName() );
            }
        } );
    }

    public static void printPeople0()
    {
        for( Person person : people )
        {
            System.out.println( person );
        }
    }

    public static void printConditionally( Condition condition )
    {
        people.stream().filter( condition::test ).forEach( System.out::println );
    }

    public static void main( String args[] )
    {
        people.forEach( System.out::println );
        people.sort( Comparator.comparing( Person::getLastName ) );
        people.forEach( System.out::println );
        printConditionally( p -> p.getLastName().startsWith( "C" ) );
        printConditionally( p -> p.getFirstName().startsWith( "C" ) );
    }
}

interface Condition{
    boolean test(Person p);
}
