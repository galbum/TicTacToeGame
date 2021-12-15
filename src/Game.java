/**
 * Represents a code for Game.
 * Using this method you could start and play the game.
 * @author Gabi Album
 */
public class Game
{
    private Player playerX;
    private Player playerO; 
    private Renderer render;
    private Board board;   
    /**
     * Constructor.
     * @param playerX First player.
     * @param playerO Second player.
     * @param renderer The render of this game.
     * @param board The board for the specific game.
     */
    public Game(Player playerX, Player playerO, Renderer renderer, Board board){
        this.playerX = playerX;
        this.playerO = playerO; 
        this.render = renderer;
        this.board = board;
    }

    /**
     * The method that runs the game.
     * @return The mark of the winner.
     * @param mark The mark that will be played.
     */
    public Mark run() {
        int counter = 1;
        while(true){
            this.render.renderBoard(this.board);
            if (counter%2 ==0){
                this.playerX.playTurn(this.board, Mark.X);
                this.render.renderBoard(this.board);
            } // end of if
            else {
                this.playerO.playTurn(this.board, Mark.O);
                this.render.renderBoard(this.board);
            }// end of else
            //System.out.println(this.board.getWinner());   
            if(this.board.gameEnded(Mark.X))
                return Mark.X;
            else if(this.board.gameEnded(Mark.O))
                return Mark.O;
            else if(counter == board.SIZE*board.SIZE){
                //System.out.println("the game has ended as a draw");
                return Mark.BLANK;
            } // end of else if(counter == board.SIZE*board.SIZE)
            counter++;            
        }//end of while
    }// end of method run
} // end of class Game
