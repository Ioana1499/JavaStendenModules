package com.jorisrietveld.containercompany.business;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 30-10-2017 13:43
 * License: GPLv3 - General Public License version 3
 *
 * The contract for all repository storeable data objects.
 */
public interface Storable
{
    /**
     * Get the unique identification code of an entity.
     * @return The unique identification code.
     */
    int getId();
}
