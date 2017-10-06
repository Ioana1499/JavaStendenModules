package Test.Scribble;

import Scribble.DrawDemo;
import org.junit.Test;

public class DrawDemoTest
{
    public static void main( String[] args )
    {
        DrawDemo demo = new DrawDemo();
        demo.drawWheel();
        //demo.colorScribble();
        //demo.hailSatan();
        demo.drawSquare();
    }
}
