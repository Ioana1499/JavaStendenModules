package Java1.src.Week4.Opdracht_441;

import Java1.src.Week4.Opdracht_440.Membership;

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
}
