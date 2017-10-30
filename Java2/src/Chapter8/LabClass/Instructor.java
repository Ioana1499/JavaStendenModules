package LabClass;

public class Instructor extends Person
{
    // the amount of credits for study taken so far
    private int credits;

    /**
     * Create a new student with a given name and ID number.
     */
    public Instructor( String fullName, String id)
    {
        super( fullName, id );
        credits = 0;
    }

    /**
     * Print the student's name and ID number to the output Terminal.
     */
    public void print()
    {
        System.out.println( getName() + ", ID: " + getId() );
    }
}
