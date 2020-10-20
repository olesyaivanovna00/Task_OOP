package com.company.service;

import com.company.objects.Board;
import com.company.objects.Domino;

public class BoardService {

    public boolean isEmpty(Board board){
        return board.getDominoes().isEmpty();
    }

    public void addDomino(Board board, Domino d){
        board.getDominoes().add(d);
    }

}
