package Test.ZuulBetter;

import ZuulBetter.Game;
import org.junit.Test;

public class GameTest
{

    /**
     * test the game.
     * @param args Commandline arguments.
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        game.play();
    }

    @Test
    public void testTheGame()
    {
        Game game = new Game();
        game.play();
    }
}
