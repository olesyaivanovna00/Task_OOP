package com.company.service;

import com.company.objects.Game;
import com.company.objects.Pack;
import com.company.objects.Board;
import com.company.objects.Domino;
import com.company.objects.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameService {
    private BoardService boardService = new BoardService();
    private DominoService dominoService = new DominoService();
    private PlayerService playerService = new PlayerService();
    private PackService packService = new PackService();

    public Game generateGame(int numOfPlayers) {
        ArrayList<Player> playerList = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            playerList.add(new Player(i + "a"));
        }

        Board newBoard = new Board();

        Pack newPack = new Pack();

        Collections.shuffle(newPack.getPack());

        for (Player player : playerList) {

            packService.addToHand(newPack, player, 7);
            //newPack.addToHand(player, 7);
        }

        return new Game(playerList, newBoard, newPack);
    }


    public void play(Game g) {
        boolean endGame = false;

        Board board = g.getNewBoard();
        Pack pack = g.getNewPack();
        int packSize = pack.getPack().size();

        //определяем кто ходит первый
        ArrayList<Player> players = g.getPlayerList();
        g.setPlayerList(sortedPlayers(firstStep(players), players));
        players = g.getPlayerList();

        int numOfSteps = 0;
        int numOfSkips;
        boolean skipped;

        do {
            numOfSkips = 0;
            for (Player p : players) {


                skipped = false;
                boolean played = false;
                Domino addedDomino = null;

                while (!played && !skipped) {

                    addedDomino = step(board, p);

                    if (addedDomino == null) {
                        if (!pack.getPack().isEmpty()) {
                            packService.addToHand(pack, p, 1);
                        } else {
                            skipped = true; //пропустил ход
                            numOfSkips++;

                        }
                    } else {
                        played = true;
                    }
                }

                numOfSteps++;
                System.out.println("\033[1;31m"+  numOfSteps + " ход: " + "\u001B[0m");
                System.out.println(p.toString());

                if (!skipped) {
                    playerService.removeDomino(p, addedDomino);
                    System.out.println(" Игрок: " + p.getName() + " ходит");
                } else {
                    System.out.println(numOfSteps + " ход: " + " Игрок: " + p.getName() + " пропустил ход");

                }
                System.out.println("\u001B[34m " + board.toString()  + "\u001B[0m");
                System.out.println("____________");

                if (p.getDominoInHand().size() == 0 && pack.getPack().size() == 0){
                    System.out.println("\u001B[31m Игрок " + p.getName() + " победил!" + "\u001B[0m");
                    return;
                }

            }


        } while (numOfSkips < players.size());


        int min = 8;
        Player wonPlayer = null;
        for (Player p: players) {
            if(p.getDominoInHand().size() < min){
                min = p.getDominoInHand().size();
                wonPlayer = p;
            }
        }

        System.out.println("\u001B[31m Игрок " + wonPlayer.getName() + " победил!" + "\u001B[0m");
        return;


    }

    private Domino step(Board board, Player player) {

        for (Domino domino : player.getDominoInHand()) {
            if (boardService.isEmpty(board)) {
                if (dominoService.isDouble(domino)) {
                    boardService.addToStart(board, domino);
                    return domino;
                }
            } else {
                Domino firstDomino = board.getDominoes().getFirst();
                Domino lastDomino = board.getDominoes().getLast();

                if (Math.abs(dominoService.toLeft(firstDomino, domino)) == 1) {
                    if (dominoService.toLeft(firstDomino, domino) == -1) {
                        domino.reverse();
                    }
                    boardService.addToStart(board, domino);
                    return domino;
                }
                if (Math.abs(dominoService.toRight(lastDomino, domino)) == 1) {
                    if (dominoService.toRight(lastDomino, domino) == -1) {
                        domino.reverse();
                    }
                    boardService.addToEnd(board, domino);
                    return domino;
                }

            }
        }

        return null;

    }


//    private boolean step(Board board, Player p, Domino d) {
//        if (bs.isEmpty(board)) {
//            if (ds.isDouble(d)) {
//                bs.addToStart(board, d);
//                return true;
//            }
//        } else {
//
//            Domino firstDomino = board.getDominoes().getFirst();
//            Domino lastDomino = board.getDominoes().getLast();
//
//            if (!ds.isDouble(lastDomino)) {
//                if (d.compareTo(lastDomino) == 12) {
//                    bs.addToEnd(board, d);
//                    return true;
//                } else if (d.compareTo(lastDomino) == 21) {
//                    d.reverse();
//                    bs.addToEnd(board, d);
//
//                    return true;
//                }
//            } else {
//                if (d.compareTo(lastDomino) == 11){
//                    bs.addToEnd(board, d);
//
//                    return true;
//                } else if(d.compareTo(lastDomino) == 22){
//                    d.reverse();
//                    bs.addToEnd(board, d);
//
//                    return true;
//                }
//            }
//
//            if (!ds.isDouble(firstDomino)) {
//                if (d.compareTo(firstDomino) == 21) {
//                    bs.addToStart(board, d);
//
//                    return true;
//                } else if (d.compareTo(firstDomino) == 11) {
//                    d.reverse();
//                    bs.addToStart(board, d);
//
//                    return true;
//                }
//            } else {
//                if (d.compareTo(firstDomino) == 11){
//                    d.reverse();
//                    bs.addToStart(board, d);
//
//                    return true;
//                } else if(d.compareTo(firstDomino) == 22){
//                    bs.addToStart(board, d);
//
//                    return true;
//                }
//            }
//        }
//        return false;
//
//    }


    private int firstStep(ArrayList<Player> players) {
        //ArrayList<Player> sortedPlayers = new ArrayList<>();
        List<Domino> dominoInHand = new ArrayList<>();

        for (int i = 0; i < players.size(); i++) {
            dominoInHand = players.get(i).getDominoInHand();
            for (Domino d : dominoInHand) {
                if (dominoService.isDouble(d)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private ArrayList<Player> sortedPlayers(int startedPosition, ArrayList<Player> players) {
        ArrayList<Player> sortedPlayers = new ArrayList<>();
        for (int i = startedPosition; i < players.size(); i++) {
            sortedPlayers.add(players.get(i));
        }
        for (int i = 0; i < startedPosition; i++) {
            sortedPlayers.add(players.get(i));
        }
        return sortedPlayers;
    }


}
