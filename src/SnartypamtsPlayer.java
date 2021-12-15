/**
 * Write a description of class MrSmartyPants here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnartypamtsPlayer implements Player
{
    /**
     * Constructor.
     */
    public SnartypamtsPlayer()  {
        // empty constructor
    } // end of constructor CleverPlayer

    /**
     * The method plays MrSmartyPants's turn.
     * @param board The current board in use.
     * @param mark The mark that needs to be played.
     */      
     public void playTurn(Board board, Mark mark) {         
        int col = board.SIZE / 2;
            for(int row=0; row < Board.SIZE; row++){
                if(board.putMark(mark, row,col) == true)
                    return;
            } //end of inner for loop
    } // end of method PlayTurn
} //end of class MrSmartyPants
