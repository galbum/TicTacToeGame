import java.util.*;
/**
 * Represents a code for the Tournament.
 * Using this method we could play the tournament.
 * @author Gabi Album
 */
public class Tournament
{

    private static final int ARG_ROUNDS = 0;   // amount of rounds
    private static final int RENDER_CONSOLE_NONE = 1; // console or none
    private static final int PLAYER_ONE_HUMAN_CLEVER_WHATEVER = 2; // choice for player one
    private static final int PLAYER_TWO_HUMAN_CLEVER_WHATEVER = 3; // choice for player two
    private static final int ARG_NUM = 4; // number of args
    private static final int NUM_OF_PLAYERS_IN_GAME = 2; // amount of players in the game

    // declerations
    private int rounds;
    private Renderer render;
    private Player[] players;
   
    /**
     * Constructor.
     * @param rounds The amount of rounds that are going to be played.
     * @param render The render of the game.
     * @param player1 The first player.
     * @param player2 The second player.
     */
    public Tournament (int rounds, Renderer render, Player[] players) {
        this.rounds = rounds;
        this.render = render;
        this.players = players;
        if(this.rounds < 1){
            System.err.print("rounds must be a postive number, please enter again");
            return;
        } // end of if
    }//end of constructor Tournament

    /**
     * The method plays the tournament
     * @return Array of the game results
     */
    public void playTournamnent(){
        int[] result = new int[3];  //array that holds the result
        //Player[] players = players; //array so we could change between X and O 
        int index = 0; // an index so we could play with players O and X
        while(this.rounds > 0){
            Board board = new Board();
            Game anotherGame = new Game(players[index%2],players[(index+1)%2], this.render, board);
            Mark gameWinner = anotherGame.run();
            if(gameWinner == Mark.O){
                if(index%2==0)
                    result[1]++;
                else
                    result[0]++;
            } // end of if
            else if(gameWinner == Mark.X){
                if(index%2==0)
                    result[0]++;
                else
                    result[1]++;
            } // end of else if
            else
                result[2]++;
            index++;
            this.rounds--;
            //System.out.print("the winner of round: " + index+ "\r" + "is:  "+gameWinner + "\r");
        }// end of while (rounds>0)
        System.out.printf("=== player 1: %d | player 2: %d | Draws: %d ===\r",result[0],result[1],result[2] );
    } // end of playTournament method

    /**
     * Main method.
     */
    public static void main(String[] args){
        // receive input
        Scanner scan = new Scanner(System.in); 
        String input = scan.nextLine(); // receive input
        args = input.split(" ", 4); //split sentence into String array args 
        while(args.length != ARG_NUM) { //if args input is invalid
            System.out.println("Usage: java Tournament [round count] [render target: console/none] [player: human/clever/whatever/...] X 2");
            input = scan.nextLine(); // receive input
            args = input.split(" ", 4); //split sentence into String array args 
        } // end of if
        int rounds = Integer.parseInt(args[ARG_ROUNDS]); 
        // init players
        PlayerFactory playerFactory = new PlayerFactory();
        Player[] players = new Player[NUM_OF_PLAYERS_IN_GAME]; //size of players
        players[0] = playerFactory.buildPlayer(args[PLAYER_ONE_HUMAN_CLEVER_WHATEVER]);
        players[1] = playerFactory.buildPlayer(args[PLAYER_TWO_HUMAN_CLEVER_WHATEVER]);

        //init render
        RendererFactory renderFactory = new RendererFactory();
        Renderer render = renderFactory.buildRenderer(args[RENDER_CONSOLE_NONE]);

        // play tournament
        Tournament tournament = new Tournament(rounds, render , players);
        tournament.playTournamnent();

    }// end of main
} //end of class Tournament
