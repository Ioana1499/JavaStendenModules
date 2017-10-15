package Runnable;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 13:36
 * License: GPLv3 - General Public License version 3
 */
public class RunnableExample
{
    public static void main( String args[] )
    {
        Thread myThread = new Thread( new Runnable(){
            @Override
            public void run()
            {
                System.out.println( "Printed in side Runnable" );
            }
        } );
        myThread.run();

        Thread myThread2 = new Thread( () -> System.out.println( "Printed in side Runnable" ) );
        myThread2.run();
    }
}
