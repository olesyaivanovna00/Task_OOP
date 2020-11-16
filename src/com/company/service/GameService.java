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
                numOfSteps++;
                System.out.println("\033[1;31m"+  numOfSteps + " ход: " + "\u001B[0m");

                skipped = false;
                boolean played = false;
                Domino addedDomino = null;

                while (!played && !skipped) {

                    addedDomino = step(board, p);

                    System.out.println(p.toString()); //выводим инфорамацию об игроке

                    if (addedDomino == null) {
                        if (!pack.getPack().isEmpty()) {

                            packService.addToHand(pack, p, 1);
                            System.out.println(" Игрок" + " \033[1m" + p.getName() + "\u001B[0m" + " взял домино.");
                        } else {

                            skipped = true; //пропустил ход
                            numOfSkips++;

                        }
                    } else {
                        System.out.println("Домино " + addedDomino.toString() + " сыграно");
                        played = true;
                    }
                }


                infoAboutGameProcess(numOfSteps, p, board, addedDomino, skipped);

                if (p.getDominoInHand().size() == 0 && pack.getPack().size() == 0){
                    System.out.println("\u001B[31m Игрок " + p.getName() + " победил!" + "\u001B[0m");
                    return;
                }

            }


        } while (numOfSkips < players.size() || board.getDominoes().size() == packSize);


        whoWon(players);



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

    private void infoAboutGameProcess(int numOfSteps, Player p, Board board, Domino addedDomino, boolean skipped){


        if (!skipped) {
            playerService.removeDomino(p, addedDomino);
            System.out.println(" Игрок" + " \033[1m" + p.getName() + "\u001B[0m" + " ходит");
        } else {
            System.out.println(numOfSteps + " ход: " + " Игрок: " + " \033[1m" + p.getName() + "\u001B[0m" +  " пропустил ход");

        }
        System.out.println("\u001B[34m " + board.toString()  + "\u001B[0m");
        System.out.println("____________");
    }

    private void whoWon(List<Player> players){
        int min = 8;
        Player wonPlayer = null;
        for (Player p: players) {
            if(p.getDominoInHand().size() < min){
                min = p.getDominoInHand().size();
                wonPlayer = p;
            }
        }

        System.out.println("\u001B[31m Игрок " + wonPlayer.getName() + " победил!" + "\u001B[0m");
    }

    private int firstStep(ArrayList<Player> players) {
        List<Domino> dominoInHand;

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
