package Test.Balls;

import balls.BallDemo;

public class BallsDemoTest
{
    private BallDemo ballDemo = new BallDemo();

    public static void main( String[] args )
    {
        BallsDemoTest ballsDemoTest = new BallsDemoTest();

        switch( 1 )
        {
            case 0:
                ballsDemoTest.testBallDemo();
                break;

            case 1:
                ballsDemoTest.testBounce();
                break;

            default:

                break;
        }
    }

    public void testBallDemo()
    {
        ballDemo.drawDemo();
    }

    public void testBounce()
    {

        ballDemo.bounce( 2 );
    }

}
