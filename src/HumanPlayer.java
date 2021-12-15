import java.util.Scanner;
/**
 * Represents a code for Human Player.
 * Using this method you could put create players and play their turns.
 * @author Gabi Album
 */
public class HumanPlayer implements Player
{
    private Scanner scan = new Scanner(System.in);
    /**
     * Constructor.
     */
    public HumanPlayer(){//empty constructor                        
    } //end of constructor

    /**
     * The method plays the turn.
     * @param board The board of the given game.
     * @param mark The mark that will be played.
     */
    public void playTurn(Board board, Mark mark) {
        System.out.println("Player " + mark + ", type coordinates: ");
        int num = scan.nextInt();
        while(board.putMark(mark,(num/10)-1,(num%10)-1) == false) {   
            System.out.println("Invalid coordinates, type again: ");   
            num = scan.nextInt();
        }
        board.putMark(mark,num/10-1,num%10-1);
    } // end of method playTurn
} // end of class HumanPlayer
