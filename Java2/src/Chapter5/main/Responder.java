package main;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * The responder class represents a response generator object. It is
 * used to generate an automatic response.
 * This is the second version of this class. This time, we generate
 * some random behavior by randomly selecting a phrase from a predefined
 * list of responses.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 0.2
 */
public class Responder
{
    /**
     * This holds the pseudo random number generator for getting random responses.
     */
    private Random randomGenerator;

    /**
     * This holds the responses that get returned.
     */
    private ArrayList<String> responses = new ArrayList<String>()
    {{
        add( "That sounds odd. Could you describe that problem in more detail?" );
        add( "No other customer has ever complained about this before. \n" + "What is your system configuration?" );
        add( "That sounds interesting. Tell me more..." );
        add( "I need a bit more information on that." );
        add( "Have you checked that you do not have a dll conflict?" );
        add( "That is explained in the manual. Have you read the manual?" );
        add( "Your description is a bit wishy-washy. Have you got an expert\n" + "there with you who could describe this more precisely?" );
        add( "That's not a bug, it's a feature!" );
        add( "Could you elaborate on that?" );
        add( "You broke it an your an horrible person!" );
    }};

    /**
     * Construct a Responder.
     */
    Responder ()
    {
        randomGenerator = new Random();
    }

    /**
     * Generate a random response.
     *
     * @return A string that should be displayed as the response
     */
    String generateResponse ()
    {
        int index = randomGenerator.nextInt( responses.size() );
        return responses.get( index );
    }
}
