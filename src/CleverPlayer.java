/**
 * Represents a code for the CleverPlayer.
 * Using this method CleverPlayer could play her turn.
 * @author Gabi Album
 */
public class CleverPlayer implements Player
{
    /**
     * Constructor.
     */
    public CleverPlayer()  {  // empty constructor
     } // end of constructor CleverPlayer

    /**
     * The method plays CleverPlayer's turn.
     * @param board The current board in use.
     * @param mark The mark that needs to be played.
     */
    public void playTurn(Board board, Mark mark) {        
        for(int row=0; row < Board.SIZE; row++) {
            for(int col=0; col < Board.SIZE; col++){
                if(board.putMark(mark, row,col) == true)
                    return;
            } //end of inner for loop
        } // end of outer for loop
    } // end of method PlayTurn
} //end of class CleverPlayer