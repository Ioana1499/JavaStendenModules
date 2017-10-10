package AdvangedBallGame.test.GameObjects;

import AdvangedBallGame.main.GameObject.Type.Oval;
import AdvangedBallGame.main.GameObject.StaticGameObject;
import org.junit.Test;

public class StaticGameObjectTest
{
    @Test
    public void testInit()
    {
        StaticGameObject<Oval> oval = new StaticGameObject<>();
    }
}
