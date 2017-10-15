package Assignment6.Main;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Company
{
    private List<Container> rantals = new ArrayList<>();

    Company()
    {

    }

    public String AddRental( String startDate, String endDate )
    {
        try{
            LocalDate startDateObject = LocalDate.parse( startDate );
            LocalDate endDateObject = LocalDate.parse( endDate );

            if( endDateObject.isBefore( startDateObject ) )
            {
                return "Could not create an rental with an end date before the start date.";
            }
        }
        catch( DateTimeParseException datetimeParseException )
        {
            return "Could not create the renal wrong date format";
        }
        return "The rental was successfully added.";
    }

    public void alterRental()
    {

    }

    public void finishRental()
    {

    }

    public void remove()
    {

    }

    public void validateDates( String firstDate, String secondate )
    {

    }
}
