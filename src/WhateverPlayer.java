import java.util.Random;
/**
 * Represents a code for the WhateverPlayer.
 * Using this method the whateverplayer will play his game.
 * @author Gabi Album
 */
public class WhateverPlayer implements Player
{
    /**
     * Constructor.
     */
    public WhateverPlayer() {   // empty constrictor    
    } // end of constructor

    /**
     * The method plays WhateverPlayer's turn.
     * @param board The current board in use.
     * @param mark The mark that needs to be played.
     */
    public void playTurn(Board board, Mark mark) {
        // instance of Random
        Random rand = new Random();   
        int randomRowCoordinate = rand.nextInt(Board.SIZE);
        int randomColCoordinate = rand.nextInt(Board.SIZE);
        while(board.putMark(mark,randomRowCoordinate,randomColCoordinate)==false) {
            randomRowCoordinate = rand.nextInt(Board.SIZE);
            randomColCoordinate = rand.nextInt(Board.SIZE);
        } // end of while
    } // end of method PlayTurn
} // end of class WhateverPlayer
