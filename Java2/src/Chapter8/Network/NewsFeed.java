package Network;

import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a
 * social network application (like FaceBook or Google+).
 * Display of the posts is currently simulated by printing the
 * details to the terminal. (Later, this should display in a browser.)
 * This version does not save the data to disk, and it does not
 * provide any search or ordering functions.
 *
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class NewsFeed
{
    private ArrayList<MessagePost> messages;
    private ArrayList<PhotoPost> photos;

    /**
     * The enum Post type.
     */
    public enum  PostType{ MESSAGE, PHOTO }

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        messages = new ArrayList<MessagePost>();
        photos = new ArrayList<PhotoPost>();
    }

    /**
     * Add a text post to the news feed.
     *
     * @param message The text post to be added.
     */
    public void addMessagePost( MessagePost message )
    {
        messages.add( message );
    }

    /**
     * Add a photo post to the news feed.
     *
     * @param photo The photo post to be added.
     */
    public void addPhotoPost( PhotoPost photo )
    {
        photos.add( photo );
    }

    /**
     * Show the news feed. Currently: print the news feed details
     * to the terminal. (To do: replace this later with display
     * in web browser.)
     */
    public void show()
    {
        messages.forEach( MessagePost::display );
        photos.forEach( PhotoPost::display );
    }

    /**
     * Gets an collection of posts from the news feed based on the post type.
     * @param type The type of posts, like messages or photo's
     * @return ArrayList<Post> An collection of posts stored on the news feed.
     */
    private ArrayList<? extends Post> getPostList( PostType type )
    {
        switch( type )
        {
            case PHOTO:
                return photos;

            case MESSAGE:
                return messages;
        }
        throw new IllegalArgumentException( String.format( "List of type: %s does not exists.", type.name() ) );
    }

    /**
     * Add comment.
     *
     * @param type    the type
     * @param index   the index
     * @param comment the comment
     */
    public void addComment( PostType type, int index, String comment )
    {
        getPostList( type ).get( index ).addComment( comment );
    }

    /**
     * Add like.
     *
     * @param type  the type
     * @param index the index
     */
    public void addLike( PostType type, int index )
    {
        getPostList( type ).get( index ).like();
    }

    /**
     * Add dislike.
     *
     * @param type  the type
     * @param index the index
     */
    public void addDislike( PostType type, int index )
    {
        getPostList( type ).get( index ).unlike();
    }
}
