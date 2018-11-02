package com.jorisrietveld.containercompany.business.Customer;

import com.jorisrietveld.containercompany.business.Storable;

/**
 * Author: Joris Rietveld <jorisrietveld@gmail.com>
 * Created: 10-11-2017 10:22
 * License: GPLv3 - General Public License version 3
 */
abstract class Customer implements Storable
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String address;
    private int securityClearence = 0;

    /**
     * Instantiates a new Customer.
     *
     * @param id              the id
     * @param firstName       the first name
     * @param lastName        the last name
     * @param email           the email
     * @param telephoneNumber the telephone number
     * @param address         the address
     */
    public Customer( int id, String firstName, String lastName, String email, String telephoneNumber, String address )
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
    }

    public Customer(){}

    @Override
    public int getId()
    {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId( int id )
    {
        this.id = id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName( String firstName )
    {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName( String lastName )
    {
        this.lastName = lastName;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail( String email )
    {
        this.email = email;
    }

    /**
     * Gets telephone number.
     *
     * @return the telephone number
     */
    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    /**
     * Sets telephone number.
     *
     * @param telephoneNumber the telephone number
     */
    public void setTelephoneNumber( String telephoneNumber )
    {
        this.telephoneNumber = telephoneNumber;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress( String address )
    {
        this.address = address;
    }

    /**
     * Retunes an string representation of an customer.
     * @return
     */
    @Override
    public String toString()
    {
        return String.format( "Customer{id=%d, firstName='%s', lastName='%s', email='%s', telephoneNumber='%s', address='%s'}", id, firstName, lastName, email, telephoneNumber, address );
    }

    protected void setSecurityClearence( int securityClarence )
    {
        this.securityClearence = securityClarence;
    }

    public int getSecurityClearence()
    {
        return this.securityClearence;
    }
}
