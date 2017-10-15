package Greeting1;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 12:20
 * License: GPLv3 - General Public License version 3
 */
public class Greeter
{

    public void greet( Greeting greeting )
    {
        greeting.perform();
    }

    public static void main( String arga[] )
    {
        Greeter greeter = new Greeter();
        HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        greeter.greet( helloWorldGreeting );

    }
}
