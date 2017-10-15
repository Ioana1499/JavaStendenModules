package Greeting2;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 12:20
 * License: GPLv3 - General Public License version 3
 */
public class Greeter
{
    @FunctionalInterface
    interface StringLengthLambda{
        int getLength(String s);
    }

    public static void main( String arga[] )
    {
        Greeter greeter = new Greeter();

        Greeting myLambda = () -> System.out.println( "Hello world!" );

        Greeting innerClassGreeting = new Greeting(){
            @Override
            public void printGreeting()
            {
                System.out.println( "Hello world!" );
            }
        };
        myLambda.printGreeting();

        StringLengthLambda stringLengthLambda = s -> s.length();
        StringLengthLambda stringLengthLambda2 = String::length;

        printLamda( s -> s.length() );

    }

    public static void printLamda( StringLengthLambda l )
    {
        System.out.println( l.getLength( "Hello lambda" ) );
    }

}