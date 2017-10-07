package BallGameTest.Util;

import BallGame.Util.ColorUtil;
import org.junit.Test;

import java.awt.*;

public class ColorUtilTest
{
    @Test
    public void getLightColorTest()
    {
        for( int i = 0; i < 20; i++ )
        {
            System.out.println( ColorUtil.getRandomLightColor().toString() );
        }

    }
}
