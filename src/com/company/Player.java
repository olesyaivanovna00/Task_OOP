package com.company;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Domino> dominoInHand;

    public Player(String name) {
        this.name = name;
        this.dominoInHand = new ArrayList<Domino>();
    }

    public String getName() {
        return name;
    }

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
    



}
