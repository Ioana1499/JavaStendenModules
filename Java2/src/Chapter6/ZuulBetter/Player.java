package ZuulBetter;

import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * The type Player.
 */
public class Player
{
    private int strength = 10;
    private String username = "Satan";
    private Room currentRoom = null;
    private HashMap<String, Item> backpack = new HashMap<>();

    /**
     * Instantiates an player object and initiates it with some basic values.
     *
     * @param username The username of the player
     */
    public Player ( String username )
    {
        this.username = username;
    }

    /**
     * Instantiates an player object and initiates it with some basic values.
     */
    public Player ()
    {}

    /**
     * This method will remove an item from the players backpack.
     * @param itemName The name of the item to remove.
     */
    public void dropItem( String itemName )
    {
        backpack.remove( itemName );
    }
    /**
     * Gets item.
     *
     * @param itemName the item name
     * @return the item
     */
    public Item getItem( String itemName )
    {
        return backpack.getOrDefault( itemName, null );
    }

    /**
     * Checks if the backpack won't get to heavy after adding an new item.
     * @param newItemWeight The weight of the new item to add.
     * @return boolean Is the user able to carry more items?
     */
    private boolean isAbleToCarry( int newItemWeight )
    {
        int totalWeight = backpack.values().stream().mapToInt( Item::getWeight ).sum();

        // If the new item exceeds the maximum weight the user can carry, notify the user.
        return this.strength < totalWeight + newItemWeight;
    }

    /**
     * Pickup item.
     *
     * @param newItem The new item the user wants to add.
     */
    public void takeItem( Item newItem)
    {
        if( newItem.getItemName().equals( "magic cookie" ) )
        {
            strength += newItem.getWeight();
            return;
        }

        if( isAbleToCarry( newItem.getWeight() ) )
        {
            this.backpack.put( newItem.getItemName(), newItem );
            System.out.printf( "The new item: %s is added to your backpack", newItem.getItemName() );
            return;
        }

        System.out.println( "Your carrying to much stuff, its to heavy..." );
        System.out.println( "You have to drop items before you can pickup any new stuf." );
    }

    public void showItems()
    {
        backpack.values().forEach( System.out::println );
    }

    /**
     * Getter for property 'username'.
     *
     * @return Value for property 'username'.
     */
    public String getUsername ()
    {
        return username;
    }

    /**
     * Setter for property 'username'.
     *
     * @param username Value to set for property 'username'.
     */
    public void setUsername ( String username )
    {
        this.username = username;
    }

    /**
     * Getter for property 'currentRoom'.
     *
     * @return Value for property 'currentRoom'.
     */
    public Room getCurrentRoom ()
    {
        return currentRoom;
    }

    /**
     * Setter for property 'currentRoom'.
     *
     * @param currentRoom Value to set for property 'currentRoom'.
     */
    public void setCurrentRoom ( Room currentRoom )
    {
        this.currentRoom = currentRoom;
    }
}
