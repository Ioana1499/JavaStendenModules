package main;

import java.util.HashMap;

public class PhoneBook
{
    HashMap<String, String> entries = new HashMap<String, String>(){{
        put("Charles Nguyen", "(531) 9392 4587");
        put("Lisa Jones", "(402) 4536 4674");
        put("William H. Smith", "(998) 5488 0123");
    }};

    public PhoneBook( HashMap<String, String> initiate )
    {
        String richardStallmanQuote = "I'm not glad he is dead, I'm glad he is gone.";
        // Split on every alpha numeric character.
        richardStallmanQuote.split("^[a-zA-Z0-9]");
        // On spaces, the character not where rockets go.
        richardStallmanQuote.split(" ");

    }

    public void enterNumber(String name, String number)
    {
        entries.put(name, number);
    }

    public String lookupNumber(String name)
    {
        return entries.getOrDefault( name, null );
    }
}
