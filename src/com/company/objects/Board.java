package com.company.objects;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private LinkedList<Domino> dominoes;  // The board contains a set of dominoes
    //private Array<Player> players;

    public Board() {
        this.dominoes = new LinkedList<Domino>();
    }

    public LinkedList<Domino> getDominoes() {
        return dominoes;
    }
}
