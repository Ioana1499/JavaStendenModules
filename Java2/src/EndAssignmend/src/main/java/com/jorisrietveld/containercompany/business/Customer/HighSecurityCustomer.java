package com.jorisrietveld.containercompany.business.Customer;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 12-11-2017 22:31
 * License: GPLv3 - General Public License version 3
 */
public class HighSecurityCustomer extends Customer implements CustomerContract
{
    public HighSecurityCustomer( int id, String firstName, String lastName, String email, String telephoneNumber, String address )
    {
        super( id, firstName, lastName, email, telephoneNumber, address );
        this.setSecurityClearence( 2 );
    }

    public HighSecurityCustomer()
    {
        this.setSecurityClearence( 2 );
    }
}
