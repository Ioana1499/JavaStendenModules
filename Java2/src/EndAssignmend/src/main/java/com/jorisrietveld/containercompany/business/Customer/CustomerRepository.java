package com.jorisrietveld.containercompany.business.Customer;

import com.jorisrietveld.containercompany.business.NonPersistingRepository;

import java.util.List;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 09:27
 * License: GPLv3 - General Public License version 3
 */
public class CustomerRepository extends NonPersistingRepository<Customer> implements CustomerRepositoryContract
{
    /**
     * Instantiates a new Customer repository.
     *
     * @param modelList the business list
     */
    public CustomerRepository( List modelList )
    {
        super( modelList );
    }

    /**
     * Gets all customers with an certain first name.
     *
     * @param firstName the first name
     * @return the by first name
     */
    @Override
    public List<Customer> getByFirstName( String firstName )
    {
        return this.getWhere( c -> c.getFirstName().equals( firstName ) );
    }

    /**
     * Gets all customers with an certain last name.
     *
     * @param lastName the last name
     * @return the by last name
     */
    @Override
    public List<Customer> getByLastName( String lastName )
    {
        return this.getWhere( c -> c.getLastName().equals( lastName ) );
    }

    /**
     * Gets all customers with an certain phone number.
     *
     * @param phoneNumber the phone number
     * @return the by phone number
     */
    @Override
    public List<Customer> getByPhoneNumber( String phoneNumber )
    {
        return this.getWhere( c -> c.getTelephoneNumber().equals( phoneNumber ) );
    }

    /**
     * Gets all customers with an certain email address.
     *
     * @param email the email
     * @return the by email
     */
    @Override
    public List<Customer> getByEmail( String email )
    {
        return this.getWhere( c -> c.getEmail().equals( email ) );
    }

    /**
     * Gets one by first name.
     *
     * @param firstName the first name
     * @return the one by first name
     */
    @Override
    public Customer getOneByFirstName( String firstName )
    {
        return this.getOneWhere( c -> c.getFirstName().equals( firstName ) );
    }

    /**
     * Gets one by last name.
     *
     * @param lastName the last name
     * @return the one by last name
     */
    @Override
    public Customer getOneByLastName( String lastName )
    {
        return this.getOneWhere( c -> c.getFirstName().equals( lastName ) );
    }

    /**
     * Gets one by phone number.
     *
     * @param phoneNumber the phone number
     * @return the one by phone number
     */
    @Override
    public Customer getOneByPhoneNumber( String phoneNumber )
    {
        return this.getOneWhere( c -> c.getFirstName().equals( phoneNumber ) );
    }

    /**
     * Gets one by email.
     *
     * @param email the email
     * @return the one by email
     */
    @Override
    public Customer getOneByEmail( String email )
    {
        return this.getOneWhere( c -> c.getFirstName().equals( email ) );
    }
}
