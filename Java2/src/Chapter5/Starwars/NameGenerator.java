package Starwars;

import org.junit.Test;

import java.util.Formatter;

public class NameGenerator
{
    public String generateFisrtName( String firstName, String lastName )
    {
        return firstName.substring( 0,1 ) + lastName.substring( 0,2 );
    }

    public String generateLastName( String maidenName, String townName )
    {
        return maidenName.substring( 0, 1 ) + townName.substring( 0, 2 );
    }

    public String generateStarWarsName( String fistName, String lastName, String maidenName, String townName )
    {
        //return String.format( "%2s%3s%2s%3s", fistName, lastName, maidenName,townName );
        return generateFisrtName( fistName, lastName ) + generateLastName( maidenName, townName );
    }

    @Test
    public void testGenerator()
    {
        System.out.println( generateStarWarsName( "aaaa", "bbbb", "cccc", "dddd" ));

    }
}
