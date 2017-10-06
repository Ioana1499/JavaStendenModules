package ZuulBetter;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 27-09-2017 00:26
 * Licence: GPLv3 - General Public Licence version 3
 */
public class Item
{
    private String itemName;
    private String description;
    private int weight;

    /**
     * Instantiates a new Item.
     *
     * @param description the description
     * @param weight      the weight
     */
    public Item ( String description, int weight )
    {
        this.description = description;
        this.itemName = description;
        this.weight = weight;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription ()
    {
        return description;
    }

    /**
     * Getter for property 'itemName'.
     *
     * @return Value for property 'itemName'.
     */
    public String getItemName ()
    {
        return itemName;
    }

    /**
     * Setter for property 'itemName'.
     *
     * @param itemName Value to set for property 'itemName'.
     */
    public void setItemName ( String itemName )
    {
        this.itemName = itemName;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription ( String description )
    {
        this.description = description;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight ()
    {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight ( int weight )
    {
        this.weight = weight;
    }

    /**
     * Gets an string representation of the items properties.
     * @return String An string that represents the item.
     */
    @Override
    public String toString ()
    {
        return String.format( "Item{ itemName='%s', description='%s', weight=%d }", itemName, description, weight );
    }
}
