package Greeting2;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 12:25
 * License: GPLv3 - General Public License version 3
 */
public class HelloWorldGreeting implements Greeting
{
    @Override
    public void printGreeting()
    {
        System.out.println( "Hello world" );
    }
}
