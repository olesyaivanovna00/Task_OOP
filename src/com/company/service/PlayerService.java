package com.company.service;

import com.company.objects.Domino;
import com.company.objects.Player;

public class PlayerService {


    public int numOfDominoInHand(Player player){
        return player.getDominoInHand().size();
    }

    public boolean isHandEmpty(Player player){
        return player.getDominoInHand().isEmpty();
    }


    public void removeDomino(Player player, Domino domino){
        player.getDominoInHand().remove(domino);
    }
    public Domino removeDominoByIndex(Player player, int index){
        Domino domino = player.getDominoInHand().get(index);
        player.getDominoInHand().remove(index);
        return domino;
    }

    public boolean hasDominoInHand(Player player, Domino domino){
        return player.getDominoInHand().contains(domino);
    }




}
