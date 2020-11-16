package com.company.service;

import com.company.objects.Board;
import com.company.objects.Domino;

public class BoardService {

    public boolean isEmpty(Board board){
        return board.getDominoes().isEmpty();
    }



    public void addToStart(Board board, Domino domino){
        board.getDominoes().addFirst(domino);
    }

    public void addToEnd(Board board, Domino domino){
        board.getDominoes().addLast(domino);
    }

    public void playedDomino(Board board, Domino domino){
        board.getDominoes().remove(domino);
    }

}
