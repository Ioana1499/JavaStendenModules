package AdvangedBallGame.test.GameObjects;

import AdvangedBallGame.main.GameObjects.Oval;
import AdvangedBallGame.main.GameObjects.StaticGameObject;
import org.junit.Test;

public class StaticGameObjectTest
{
    @Test
    public void testInit()
    {
        StaticGameObject<Oval> oval = new StaticGameObject<>();
    }
}
