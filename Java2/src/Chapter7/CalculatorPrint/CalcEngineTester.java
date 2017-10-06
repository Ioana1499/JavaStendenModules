package CalculatorPrint;

import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test the CalcEngine class.
 *
 * @author Hacker T. Largebrain
 * @version 1.0
 */
public class CalcEngineTester
{
    // The engine to be tested.
    private CalcEngine engine;

    /**
     * Constructor for objects of class CalcEngineTester
     */
    public CalcEngineTester()
    {
        engine = new CalcEngine();
    }

    /**
     * Test everything.
     */
    @Test
    public void testAll()
    {
        System.out.println("Testing the addition operation.");
        System.out.println("The result is: " + testPlus());
        System.out.println("Testing the subtraction operation.");
        System.out.println("The result is: " + testMinus());
        System.out.println("All tests passed.");
    }

    /**
     * Test the plus operation of the engine.
     *
     * @return the result of calculating 3+4.
     */
    public int testPlus()
    {
        // Make sure the engine is in a valid starting state.
        engine.clear();
        engine.numberPressed(3);
        engine.plus();
        engine.numberPressed(4);
        engine.equals();
        return engine.getDisplayValue();
    }

    /**
     * Assignment 722 test.
     */
    @Test
    public void assignment722Test()
    {
         assertEquals( 7, testPlus() );
         assertEquals( 7, testPlus() );
    }

    /**
     * Test the minus operation of the engine.
     *
     * @return the result of calculating 9 - 4.
     */
    public int testMinus()
    {
        // Make sure the engine is in a valid starting state.
        engine.clear();
        // Simulate the presses: 9 - 4 =
        engine.numberPressed(9);
        engine.minus();
        engine.numberPressed(4);
        engine.equals();
        // Return the result, which should be 5.
        return engine.getDisplayValue();
    }

    /**
     * Assignment 723 test.
     */
    @Test
    public void assignment723Test()
    {
        assertEquals( 5, testMinus() );
        assertEquals( 5, testMinus() );
    }

    /**
     * Assignment 724 test.
     */
    @Test
    public void assignment724ClearTest()
    {
        CalcEngine calcEngine = new CalcEngine();
        engine.numberPressed( 9 );
        engine.minus();
        engine.numberPressed( 9 );
        engine.clear();
        assertEquals( ' ', engine.getPreviousOperator() );
        assertEquals( 0, engine.getDisplayValue() );
        assertEquals( 0, engine.getLeftOperand() );
    }
}
