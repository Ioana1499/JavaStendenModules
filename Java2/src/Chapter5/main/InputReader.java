package main;

import java.util.Scanner;

/**
 * InputReader reads typed text input from the standard text Terminal.
 * The text typed by a user is then chopped into words, and a set of words
 * is provided.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 0.2
 */
public class InputReader
{
    /**
     * The scanner used to receive the users question.
     */
    private Scanner reader;

    /**
     * Create a new InputReader that reads text from the text Terminal.
     */
    public InputReader()
    {
        reader = new Scanner(System.in);
    }

    /**
     * Read a line of text from standard input (the text Terminal),
     * and return it as a String.
     *
     * @return A String typed by the user.
     */
    public String getInput()
    {
        System.out.print("> ");         // print prompt
        return reader.nextLine();
    }
}
