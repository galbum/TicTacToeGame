/**
 * Represents a code for the PlayerFactory.
 * Using this method we can use all the different players.
 * @author Gabi Album
 */
public class PlayerFactory
{
    /**
     * Constructor.
     */
    public PlayerFactory(){ // empty constructor
    }// end of constructor

    /**
     * The method builds the player that needs to be in use.
     * @param playerType The type of player that need to be in use.
     * @return A new player variable.
     */
    public Player buildPlayer(String playerType){
        switch(playerType){
            case "human":
            return new HumanPlayer();

            case "whatever":
            return new WhateverPlayer();

            case "clever":
            return new CleverPlayer();

            case "snartypamts":
            return new SnartypamtsPlayer();

            default:
            return null;
        } // end of switch
    } // end of method buildPlayer
} //end of class PlayerFactory