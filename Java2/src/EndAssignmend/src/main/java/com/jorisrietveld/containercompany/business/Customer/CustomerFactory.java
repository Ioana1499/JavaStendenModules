package com.jorisrietveld.containercompany.business.Customer;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 12-11-2017 22:35
 * License: GPLv3 - General Public License version 3
 */
public class CustomerFactory
{
    public enum CustomerType{
        RETAIL,
        HIGH_SECURITY
    }

    public Customer getCustomer( CustomerType type )
    {
        switch( type )
        {
            case RETAIL:
                return new RetailCustomer( );
            case HIGH_SECURITY:
                return new HighSecurityCustomer();
                default:
                    throw new IllegalArgumentException( "Wrong customer type." );
        }
    }
}
