package com.company.objects;

import com.company.objects.Domino;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static int numOfPlayers = 0;
    private String name;
    private List<Domino> dominoInHand;
    List<Domino> hand;


    public Player(String name) {
        numOfPlayers++;
        this.name = name;
        this.dominoInHand = new ArrayList<Domino>();
    }



    public String getName() { return name; }

    public List<Domino> getDominoInHand() {
        return dominoInHand;
    }

    public int numOfDominoInHand(){
        return dominoInHand.size();
    }

    public boolean isHandEmpty(){
        return dominoInHand.isEmpty();
    }

    public void addDomino(Domino domino){
        this.dominoInHand.add(domino);
    }

    public Domino removeDom(int index){
        Domino domino = dominoInHand.get(index);
        dominoInHand.remove(index);
        return domino;
    }

    public boolean hasDominoInHand(Domino domino){
        return dominoInHand.contains(domino);
    }


    public boolean hasPlay(int side){
        for (Domino domInHand : dominoInHand){
            if( (side == domInHand.getBone1()) || (side == domInHand.getBone2()) ){
                return true;
            }
        }
        return false;
    }

    public static int getNumOfPlayers() {
        return numOfPlayers;
    }

    public List<Domino> getHand(){
        return this.hand;
    }

    public int numOfDomInHand(){
        return hand.size();
    }



}
