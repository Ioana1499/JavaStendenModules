package com.jorisrietveld.containercompany.business.Customer;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 10:04
 * License: GPLv3 - General Public License version 3
 */
public class RetailCustomer extends Customer implements CustomerContract
{
    public RetailCustomer( int id, String firstName, String lastName, String email, String telephoneNumber, String address )
    {
        super( id, firstName, lastName, email, telephoneNumber, address );
    }

    public RetailCustomer()
    {
    }
}
