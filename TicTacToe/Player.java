import  java.util.Scanner;
/**
 * Represents a code for Player.
 * Using this method you could put create players and play their turns.
 * @author Gabi Album
 */
public class Player
{
    private Scanner scan = new Scanner(System.in);
    /**
     * Constructor.
     */
    public Player(){//empty constructor                        
    } //end of constructor

     /**
     * The method plays the turn.
     * @param board The board of the given game.
     * @param mark The mark that will be played.
     */
    public void playTurn(Board board, Mark mark) {
        int num = scan.nextInt();
        while(board.putMark(mark,(num/10)-1,(num%10)-1) == false) {   
            System.out.println("you have entered a wrong coordinates, please enter an integer between 1 and  " + board.SIZE + "  or the coordinates you have entered are in use, please enter again");   
            num = scan.nextInt();
        }
        board.putMark(mark,num/10-1,num%10-1);
    } // end of method playTurn
} // end of class player
