package com.jorisrietveld.containercompany.business.Customer;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:30
 * License: GPLv3 - General Public License version 3
 *
 * An contract for creating customer implementations.
 */
public interface CustomerContract
{
    /**
     * Gets first name.
     *
     * @return the first name
     */
    String getFirstName();

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    void setFirstName( String firstName );

    /**
     * Gets last name.
     *
     * @return the last name
     */
    String getLastName();

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    void setLastName( String lastName );

    /**
     * Gets email.
     *
     * @return the email
     */
    String getEmail();

    /**
     * Sets email.
     *
     * @param email the email
     */
    void setEmail( String email );

    /**
     * Gets telephone number.
     *
     * @return the telephone number
     */
    String getTelephoneNumber();

    /**
     * Sets telephone number.
     *
     * @param telephoneNumber the telephone number
     */
    void setTelephoneNumber( String telephoneNumber );

    /**
     * Gets address.
     *
     * @return the address
     */
    String getAddress();

    /**
     * Sets address.
     *
     * @param address the address
     */
    void setAddress( String address );
}
