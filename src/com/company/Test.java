package com.company;

import com.company.objects.Board;
import com.company.objects.Domino;
import com.company.objects.Pack;
import com.company.objects.Player;

public class Test {

    public static void playGame(){
        Board board = new Board();

        Pack pack = new Pack();
        //pack.shuffle();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        DominoClass();
    }

    private static void DominoClass(){
        System.out.println("-- Тестирование класса домино --");
        System.out.println();

        Domino dom1 = new Domino(5,5); // 5 | 5
        Domino dom2 = new Domino(6,4); // 6 | 4
        Domino dom3 = new Domino(5,5); // 5 | 5

        System.out.println("Домино 1 - " + dom1);
        System.out.println("Домино 2 - " + dom2);



        System.out.println();
        System.out.println(dom1 + " = " + dom1 + " ? " + dom1.equals(dom1)); // true
        System.out.println(dom1 + " = " + dom2 + " ? " + dom1.equals(dom2)); // false
        System.out.println(dom1 + " = " + dom3 + " ? " + dom1.equals(dom3)); // true
    }

    private static void PlayerClass() {
        System.out.println("-- Тестирование класса игроков --");
        System.out.println();

        Player player1 = new Player("Олег");
        Player player2 = new Player("Алексей");


        System.out.println();

        System.out.println(player1 + "\n");
        System.out.println(player2);

        System.out.println();

        Domino dom1 = new Domino(5, 5);
        Domino dom2 = new Domino(6, 4);
        Domino dom3 = new Domino(1, 0);

        player1.addDomino(dom1);
        player1.addDomino(dom2);

        player2.addDomino(dom1);
        player2.addDomino(dom3);




    }


}
