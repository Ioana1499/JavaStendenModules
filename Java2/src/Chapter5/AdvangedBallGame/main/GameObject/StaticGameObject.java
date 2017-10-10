package AdvangedBallGame.main.GameObject;

public class StaticGameObject<GameObjectShape> extends GameObject
{
    /**
     * Decrease the global game object count.
     * @throws Throwable If an exception occurs during the destruction of the object.
     */
    @Override
    protected void finalize() throws Throwable
    {
        GameObject.decreaseObjectCount();
        super.finalize();
    }
}
