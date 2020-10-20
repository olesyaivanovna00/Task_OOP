package com.company.service;

import com.company.Game;
import com.company.Pack;
import com.company.objects.Board;
import com.company.objects.Domino;
import com.company.objects.Player;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private BoardService bs = new BoardService();
    private DominoService ds = new DominoService();
    private PlayerService ps = new PlayerService();

    public Game generateGame(int numOfPlayers){
        ArrayList<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            playerList.add(new Player(""));
        }
        bs.isEmpty()

        Board newBoard = new Board();
        Pack newPack = new Pack();


        newPack.shuffle();

        for(Player player: playerList) {
            newPack.addToHand(player, 7);
        }

        return new Game(playerList, newBoard, newPack);
    }


    public void play(Game g){
        //boolean endGame = true;

        //определяем кто ходит первый
        ArrayList<Player> players = g.getPlayerList();
        g.setPlayerList(sortedPlayers(firstStep(players) , players));


        for (Player p:g.getPlayerList()) {
            for (Domino d: p.getDominoInHand()) {
                if (bs.isEmpty(g.getNewBoard())){
                    if (d.isDouble()){
                        
                    }
                }
            }
        }
    }

    private int firstStep(ArrayList<Player> players){
        ArrayList<Player> sortedPlayers = new ArrayList<>();


        for (int i = 0; i < players.size(); i++) {
            for (Domino d: players.get(i).getDominoInHand()) {
                if (d.isDouble()){
                    return i;
                }
            }
        }
        return 0;
    }

    private ArrayList<Player> sortedPlayers(int startedPosition, ArrayList<Player> players){
        ArrayList<Player> sortedPlayers = new ArrayList<>();
        for (int i = startedPosition; i < players.size(); i++) {
            sortedPlayers.add(players.get(i));
        }
        for (int i = 0; i < startedPosition; i++) {
            sortedPlayers.add(players.get(i));
        }
        return sortedPlayers;
    }
}
