package AdvangedBallGame.main.CollisionPhysics;

public class CollisionResponse
{
    private static final float RESPONSE_TIME_LIMIT = 0.005f;

    public float timeOfCollision;

    public float newSpeedX;
    public float newSpeedY;

    public CollisionResponse()
    {
        reset();
    }

    public void reset()
    {
        this.timeOfCollision = Float.MAX_VALUE;
    }

    /** Copy this instance to another, used to find the earliest collision. */
    public void copy( CollisionResponse another )
    {
        this.timeOfCollision = another.timeOfCollision;
        this.newSpeedX = another.newSpeedX;
        this.newSpeedY = another.newSpeedY;
    }

    public float getNewX(float currentX, float speedX )
    {
        return timeOfCollision > RESPONSE_TIME_LIMIT ? (float) (currentX + speedX * (timeOfCollision - RESPONSE_TIME_LIMIT)) : currentX;
    }

    public float getNewY(float currentY, float speedY )
    {
        return timeOfCollision > RESPONSE_TIME_LIMIT ? (float)(currentY + speedY * (timeOfCollision - RESPONSE_TIME_LIMIT) ) : currentY;
    }

}
