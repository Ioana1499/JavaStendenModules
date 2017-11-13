package com.jorisrietveld.containercompany.business.Customer;

import java.util.List;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 10:04
 * License: GPLv3 - General Public License version 3
 * An contract for creating customer repository implementations.
 */
public interface CustomerRepositoryContract
{
    /**
     * Gets all customers with an certain first name.
     *
     * @param firstName the first name
     * @return the by first name
     */
    List<Customer> getByFirstName( String firstName );

    /**
     * Gets all customers with an certain last name.
     *
     * @param lastName the last name
     * @return the by last name
     */
    List<Customer> getByLastName( String lastName );

    /**
     * Gets all customers with an certain phone number.
     *
     * @param phoneNumber the phone number
     * @return the by phone number
     */
    List<Customer> getByPhoneNumber( String phoneNumber );

    /**
     * Gets all customers with an certain email address.
     *
     * @param email the email
     * @return the by email
     */
    List<Customer> getByEmail( String email );

    /**
     * Gets one by first name.
     *
     * @param firstName the first name
     * @return the one by first name
     */
    Customer getOneByFirstName( String firstName );

    /**
     * Gets one by last name.
     *
     * @param lastName the last name
     * @return the one by last name
     */
    Customer getOneByLastName( String lastName );

    /**
     * Gets one by phone number.
     *
     * @param phoneNumber the phone number
     * @return the one by phone number
     */
    Customer getOneByPhoneNumber( String phoneNumber );

    /**
     * Gets one by email.
     *
     * @param email the email
     * @return the one by email
     */
    Customer getOneByEmail( String email );
}
