package LabClass;

public abstract class Person
{
    private String name;
    private String id;

    public Person( String name, String id )
    {
        this.name = name;
        this.id = id;
    }

    /**
     * Return the student ID of this student.
     */
    public String getId()
    {
        return id;
    }

    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName( String replacementName )
    {
        this.name = replacementName;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring( 0, 4 ) + id.substring( 0, 3 );
    }
}
