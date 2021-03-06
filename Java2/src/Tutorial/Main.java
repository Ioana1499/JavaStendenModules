/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 19:02
 * License: GPLv3 - General Public License version 3
 */
public class Main
{
    public static void main( String[] args )
    {
        int a = 10;
        int b = 20;
        doProcess( a, new Process(){
            @Override
            public void process( int i )
            {
                System.out.println( i );
            }
        } );

        doProcess( a, i -> System.out.println( i + b ) );
    }

    public static void doProcess( int i, Process p)
    {
        p.process( i );
    }
}

interface Process{
    void process(int i);
}
