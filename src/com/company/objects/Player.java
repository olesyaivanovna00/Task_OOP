package com.company.objects;

import com.company.objects.Domino;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private List<Domino> dominoInHand;


    public Player(String name) {

        this.name = name;
        this.dominoInHand = new ArrayList<Domino>();
    }



    public String getName() { return name; }

    public List<Domino> getDominoInHand() {
        return dominoInHand;
    }

    public void addDomino(Domino domino){
        this.dominoInHand.add(domino);
    }

    @Override
    public String toString() {
        String str = "У игрока " + name + ":";

        for (Domino d: dominoInHand) {
            str += " " + d.toString() + " ";
        }
        return str;
    }
}
