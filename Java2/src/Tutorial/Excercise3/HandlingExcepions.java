package Excercise3;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 15-10-2017 17:51
 * License: GPLv3 - General Public License version 3
 */
public class HandlingExcepions
{
    static int[] someNumbers = { 1, 2, 3, 4 };
    static int key = 2;

    public static void main( String[] args )
    {
        //process( someNumbers, 0, ( v, k ) -> System.out.println( v / k ) );
        process( someNumbers, 0, CheckedBiConsumer( ( v, k ) -> System.out.println( v / k ) ) );
    }

    public static void process( int[] nums, int key, BiConsumer<Integer, Integer> consumer )
    {
        /*
        for( int i: nums ){
            consumer.accept( i, key );
        }
        */
        Arrays.stream( nums ).forEach( i -> consumer.accept( i, key ) );
    }

    private static BiConsumer<Integer, Integer> CheckedBiConsumer( BiConsumer<Integer, Integer> consumer )
    {
        return ( v, k ) -> {
            try{
                consumer.accept( v, k );
            }
            catch( Exception e )
            {
                System.out.println( "Printed from exception handler:" );
                //e.printStackTrace();
            }
        };
    }
}