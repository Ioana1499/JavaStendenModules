package AdvangedBallGame.main.GameObject;

public class DynamicGameObject extends GameObject
{
    //TODO: add methods for collision detection.
    //TODO: add methods for moving the object.
    //TODO: add methods for resizing the object.
    //TODO: add methods for painting the object.
    //TODO: add methods for rotating the object.


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
