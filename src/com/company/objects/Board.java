package com.company.objects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Board {
    private LinkedList<Domino> dominoes;
    //private Array<Player> players;

    public Board() {
        this.dominoes = new LinkedList<>();
    }

    public LinkedList<Domino> getDominoes() {
        return dominoes;
    }

    public void addDomino(Domino domino){
        dominoes.add(domino);
    }

    @Override
    public String toString() {
        String str = "";
        for (Domino d:dominoes) {
            str += " " + d.toString() + " ";
        }

        return str;
    }
}
