/*
package Assignment6.jorisrietveld.util.function;

import Assignment6.ContainerCompany.LambdaExceptionsUtil;

import java.util.Objects;
import java.util.function.Function;

*/
/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 18-10-2017 02:42
 * License: GPLv3 - General Public License version 3
 *//*


@FunctionalInterface
public interface ThrowingBiConsumer<T, U> extends BiConsumer<T, U>
{
    */
/**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     *//*

    @Override
    default void accept( T t, U u )
    {
        try
        {

        }
        catch( Exception exception )
        {

        }
    }

    default ThrowingBiConsumer<T, U> andThen( ThrowingBiConsumer<? extends T, ? extends U> after )
    {
        Objects.requireNonNull( after );
        try
        {
            return ( l, r ) -> {
                accept( l, r );
            };
        }
        catch( Exception e )
        {
            throw new RuntimeException( e );
        }
    }

    void acceptThrows( T t, U u) throws Exception;
}
*/
