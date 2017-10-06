import java.util.ArrayList;
/**
 * Store details of club memberships.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Club
{
    private ArrayList<Membership> members;
    
    // Define any necessary fields here ...
    
    /**
     * Constructor for objects of class Club
     */
    public Club( ArrayList<Membership> members )
    {   
        this.members = new ArrayList<>();
        this.members = members;
    }

    /**
     * Add a new member to the club's list of members.
     * @param member The member object to be added.
     */
    public void join(Membership member)
    {
        this.members.add( member );
    }

    /**
     * @return The number of members (Membership objects) in
     *         the club.
     */
    public int numberOfMembers()
    {
        return this.members.size();
    }
    
    /**
    * Determine the number of members who joined in the
    * given month.
    * @param month The month we are interested in.
    * * @return The number of members who joined in that month.
    */
    public int joinedInMonth(int month)
    {
        int amountOfMembers = 0;
        
        for( Membership currentMemeber : members ) 
        {
            if( currentMemeber.getMonth() == month )
            {
                amountOfMembers++;
            }
        }
        
        return amountOfMembers;
    }
    /**
    * Remove from the club's collection all members who
    * joined in the given month, and return them stored
    * in a separate collection object.
    * @param month The month of the membership.
    * @param year The year of the membership.
    * @return The members who joined in the given month and year.
    */
    public ArrayList<Membership> purge(int month, int year)
    {
        ArrayList<Membership> bannedMembers = new ArrayList<>();
        int iterationCounter = 0;
        
        for( Membership currentMemeber : members ) 
        {
            if( currentMemeber.getMonth() == month && currentMemeber.getYear() == year )
            {
                bannedMembers.add( currentMemeber );
                members.remove( iterationCounter );
            }
            iterationCounter++;
        }
        
        return bannedMembers;
    }
}