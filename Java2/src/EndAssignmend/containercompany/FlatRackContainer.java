package containercompany;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 23-10-2017 00:06
 * License: GPLv3 - General Public License version 3
 *
 * This data object is en specific type of container.
 */
class FlatRackContainer extends Container
{
    /**
     * Create an new standard Flat Rack container.
     *
     * @param id
     */
    FlatRackContainer( int id )
    {
        super( id, 2.50, 6, 1.50 );
        this.setRentM3( 35 );
    }
}
