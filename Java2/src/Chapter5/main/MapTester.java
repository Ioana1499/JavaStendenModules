package main;

import java.util.HashMap;

/**
 * Write a description of class MapTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MapTester
{
    // instance variables - replace the example below with your own

    HashMap<String, String> phoneBook = new HashMap<String, String>();


    /**
     * Constructor for objects of class MapTester
     */
    public MapTester()
    {
        // initialise instance variables

    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public void enterNumber(String name, String number)
    {
        // put your code here
        phoneBook.put(name, number);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param y a sample parameter for a method
     * @return the sum of x and y
     */
    public void lookupNumber(String name)
    {
        // put your code here
        String number = phoneBook.get(name);
        System.out.println(name + ": " + number);
    }
}
