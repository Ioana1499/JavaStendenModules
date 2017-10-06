package Network.Test;

import Network.MessagePost;
import Network.NewsFeed;
import Network.PhotoPost;

import java.util.ArrayList;

public class Assignments81
{
    NewsFeed newsFeed = new NewsFeed();

    public void initMessages()
    {
        ArrayList<MessagePost> messages = new ArrayList<MessagePost>()
        {{
            add( new MessagePost( "Bob", "secret message" ) );
            add( new MessagePost( "Eve", "Ciphertext" ) );
            add( new MessagePost( "Alice", "Decrypted message" ) );
        }};

        messages.forEach( messagePost -> newsFeed.addMessagePost( messagePost ) );
    }

    public void initPhotos()
    {
        ArrayList<PhotoPost> photos = new ArrayList<PhotoPost>()
        {{
            add( new PhotoPost( "xkcd", "img1.png", "To damn accurate!"  ));
            add( new PhotoPost( "xkcd", "img2.png", "Try mindfck..."  ));
            add( new PhotoPost( "xkcd", "img3.png", "Currently testing this hypotheses" ));
        }};

        photos.forEach( photo -> newsFeed.addPhotoPost( photo ) );
    }

    public static void main( String[] args )
    {
        Assignments81 assignment = new Assignments81();
        assignment.initMessages();
        assignment.initPhotos();
        assignment.newsFeed.show();

    }
}
