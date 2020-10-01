package com.company;

import java.util.LinkedList;
import java.util.List;

public class Board {
    private List<Domino> dominoes;  // The board contains a set of dominoes
    private int playerOne, playerTwo;

    public Board() {
        this.dominoes = new LinkedList<Domino>();

    }
}
