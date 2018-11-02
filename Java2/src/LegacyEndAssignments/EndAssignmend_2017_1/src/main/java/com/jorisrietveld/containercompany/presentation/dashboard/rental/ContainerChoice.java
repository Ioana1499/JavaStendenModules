package com.jorisrietveld.containercompany.presentation.dashboard.rental;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 08-11-2017 05:41
 * License: GPLv3 - General Public License version 3
 */
public class ContainerChoice
{
    /**
     * The Id.
     */
    Integer id;
    /**
     * The Display string.
     */
    String displayString;

    /**
     * Instantiates a new Container choice.
     *
     * @param id the id
     */
    ContainerChoice( Integer id )
    {
        this( id, null );
    }

    /**
     * Instantiates a new Container choice.
     *
     * @param displayString the display string
     */
    ContainerChoice( String displayString )
    {
        this( null, displayString );
    }

    /**
     * Instantiates a new Container choice.
     *
     * @param id            the id
     * @param displayString the display string
     */
    ContainerChoice( Integer id, String displayString )
    {
        this.id = id;
        this.displayString = displayString;
    }

    @Override
    public String toString()
    {
        return displayString;
    }

    @Override
    public boolean equals( Object o )
    {
        if( this == o )
        {
            return true;
        }
        if( o == null || getClass() != o.getClass() )
        {
            return false;
        }
        ContainerChoice choice = (ContainerChoice) o;
        return displayString != null && displayString.equals( choice.displayString ) || id != null && id.equals( choice.id );
    }

    @Override public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (displayString != null ? displayString.hashCode() : 0);
        return result;
    }
}
