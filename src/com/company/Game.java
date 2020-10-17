package com.company;

import java.util.List;

public class Game {


    private int numOfPlayers;
    private List<Player> playerList;

    public Game(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }

    public void startGame(int numOfPlayers){
        for (int i = 0; i < numOfPlayers; i++) {
            TextInterface txt = new TextInterface();
            String name = txt.playerName();
            playerList.add(new Player(name));
        }


        Board newBoard = new Board();

        Pack newPack = new Pack();

        newPack.shuffle();

        for(Player player: playerList) {
            newPack.addToHand(player, 7);
        }

    }
}
