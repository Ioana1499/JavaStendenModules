package Assignment6.Main1;

public class FullContainerException extends Exception
{
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public FullContainerException( int amountToStore, int remainingStorageCapasity )
    {
        super( String.format( "Unable to store: %d content, remaining size left: %d", amountToStore, remainingStorageCapasity ) );
    }
}
