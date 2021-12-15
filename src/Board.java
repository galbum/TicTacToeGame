/**
 * Represents a code for Board.
 * Using this method you could put mark and check game status
 * @author Gabi Album
 */
public class Board
{
    /**
     * The options that the game is in.
     */
    private enum GAMEOPTIONS {DRAW, X_WIN, O_WIN , IN_PROGRESS};
    /**
     * Size of the board.
     */
    public static final int SIZE = 6 ; 
    /**
     * The amount of marks in a row/column/diagnal needed to win.
     */
    public static final int WIN_STREAK = 4;
    // decleration
    private Mark[][] board;
    private int counter = 0;

    /**
     * Constructor.
     */
    Board() { //default constructor
        this.board = new Mark[SIZE][SIZE];
    } // end of defualt constructor

    /**
     * The method will check if the place given is valid and if yes will add mark
     * @param mark The mark we want to add.
     * @param row The row coordinate.
     * @param col The col coordinate.
     * @return true if valid, else false.
     */
    public boolean putMark(Mark mark, int row, int col){
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) { // Illegal input
            return false;
        }

        if(this.board[row][col] == Mark.X || this.board[row][col] == Mark.O) // check if the place entered is empty
            return false;
        this.counter++; // add one to counter
        this.board[row][col] = mark; // colour the area O or X
        return true;     
    }// end of method putMark

     /**
     * The method checks the status of the game.
     * @return Status of the game.
     */
     public Mark getWinner (){  
        int countX = 0, countO = 0;
        if(gameEnded(Mark.X) == true)
            return Mark.X;
        else if (gameEnded(Mark.O) == true)
            return Mark.O;
        else 
            return Mark.BLANK;       
    } // end of method GameStatus
    
     /**
     * The method checks the mark on specific coordinates.
     * @param row The row coordinate.
     * @param col The col coordinate.
     * @return Mark on given coordinates.
     */
    public Mark getMark(int row, int col){
        if(row < 0 || col < 0 || row > SIZE || col > SIZE)
               return null;
        if(this.board[row][col] == Mark.X)
            return Mark.X;        
        else if(this.board[row][col]== Mark.O)
            return Mark.O;
        else 
            return Mark.BLANK;            
    } // end of method getMark

    /**
     * The method checks if their is a winner.
     * @param mark The mark that needs to be checked.
     * @return true if the mark won, else returns false.
     */
    public boolean gameEnded(Mark mark){
        for(int row=0; row<SIZE; row++){
            for(int col=0; col<SIZE;col++){
                if(this.board[row][col] == mark){
                    //check left
                    if(countMarkInDirection(row,col,-1,0,mark)==WIN_STREAK)
                        return true;
                    //check right
                    else if(countMarkInDirection(row,col,1,0,mark)==WIN_STREAK)
                        return true;
                    // check up    
                    else if(countMarkInDirection(row,col,0,-1,mark)==WIN_STREAK)
                        return true;
                    //check down
                    else if(countMarkInDirection(row,col,0,1,mark)==WIN_STREAK)
                        return true;
                    // check diagonal left up
                    else if(countMarkInDirection(row,col,-1,-1,mark)==WIN_STREAK)
                        return true;
                    // check diagonal left down
                    else if(countMarkInDirection(row,col,-1,1,mark)==WIN_STREAK)
                        return true;
                    // check diagonal right down
                    else if(countMarkInDirection(row,col,1,1,mark)==WIN_STREAK)
                        return true;
                    // check diagonal right up
                    else if(countMarkInDirection(row,col,1,-1,mark)==WIN_STREAK)
                        return true;
                } // end of if
            } //end of inner for loop
        }// end of outer for loop
        return false; // the game hasn't ended
    } // end of method didWin
    
     /**
     *  Implementation comment for private methods.
     *  Count how many marks in a row for a given cell and direction.
     */
    private int countMarkInDirection(int row, int col, int rowDelta, int colDelta, Mark mark) {
        int count = 0;
        while(row < SIZE && row >= 0 && col < SIZE && col >= 0 && board[row][col] == mark) {
            count++;
            row += rowDelta;
            col += colDelta;
        }
        return count;
    } // end of countMarkInDirection
}// end of class Board 