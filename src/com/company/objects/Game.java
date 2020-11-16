package com.company.objects;

import com.company.objects.Board;
import com.company.objects.Pack;
import com.company.objects.Player;

import java.util.ArrayList;

public class Game {


    private ArrayList<Player> playerList;
    private Board newBoard;
    private Pack newPack;

    public Game(ArrayList<Player> playerList, Board newBoard, Pack newPack) {
        this.playerList = playerList;
        this.newBoard = newBoard;
        this.newPack = newPack;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public Board getNewBoard() {
        return newBoard;
    }

    public Pack getNewPack() {
        return newPack;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }
}
