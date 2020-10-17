package com.company;

public class Test {

    public static void playGame(){
        Board board = new Board();

        Pack pack = new Pack();
        pack.shuffle();

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
        System.out.println("Общее значение " + dom1 + " - " + dom1.getTotalValue());
        System.out.println("Общее значение " + dom2 + " - " + dom2.getTotalValue());


        System.out.println();
        System.out.println(dom1 + " двойное домино - " + dom1.isDouble());
        System.out.println(dom2 + " двойное домино - " + dom2.isDouble());

        System.out.println();
        System.out.println(dom1 + " и " + dom2 + " одинаковое общее значение " + dom1.isSameValue(dom2)); // true

        System.out.println();
        System.out.println(dom1 + " = " + dom1 + " ? " + dom1.equals(dom1)); // true
        System.out.println(dom1 + " = " + dom2 + " ? " + dom1.equals(dom2)); // false
        System.out.println(dom1 + " = " + dom3 + " ? " + dom1.equals(dom3)); // true
    }

    private static void PlayerClass() {
        System.out.println("-- Тестирование класса игроков --");
        System.out.println();

        Player richie = new Player("Олег");
        Player dwayne = new Player("Алексей");


        System.out.println("В игре " + Player.getNumOfPlayers() + " игрока");

        System.out.println();

        System.out.println(richie + "\n");
        System.out.println(dwayne);

        System.out.println();
        System.out.println("Есть ли у " + richie.getName() + " домино? " + richie.isHandEmpty()); // should be false;

        Domino dom1 = new Domino(5, 5);
        Domino dom2 = new Domino(6, 4);
        Domino dom3 = new Domino(1, 0);

        richie.addDomino(dom1);
        richie.addDomino(dom2);

        dwayne.addDomino(dom1);
        dwayne.addDomino(dom3);


        System.out.println();
        System.out.println(richie.getName() + " в руках:\n");
        for (Domino dom : richie.getHand()) {
            System.out.println(dom);
        }

        System.out.println();
        System.out.println(dwayne.getName() + " в руках:\n");
        for (Domino dom : dwayne.getHand()) {
            System.out.println(dom);
        }

        /* Dwayne should have 3 dominos in his hand */
        System.out.println();
        System.out.println("Is " + dwayne.getName() + " hand empty? " + dwayne.isHandEmpty()); // should be false;

        /* The number of dominos in each hand */
        System.out.println();
        System.out.println(richie.getName() + " has " + richie.numOfDomInHand() + " in their hand."); // should be 2
        System.out.println(dwayne.getName() + " has " + dwayne.numOfDomInHand() + " in their hand."); // should be 3

        /* Test the hasPlay() method */
        System.out.println();
        System.out.println(richie.getName() + " can play a matching domino with a side of " + dom1.getBone1() + "? " + richie.hasPlay(dom1.getBone1())); // should be true
        System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom2.getBone1() + "? " + dwayne.hasPlay(dom2.getBone1())); // should be false
        System.out.println(dwayne.getName() + " can play a matching domino with a side of " + dom3.getBone1() + "? " + dwayne.hasPlay(dom3.getBone1())); // should be true

        /* Check hasDomino() method */
        System.out.println();
        System.out.println(dwayne.getName() + " has " + dom3 + " in his hand? " + dwayne.hasDominoInHand(dom3)); // should be true
        System.out.println(richie.getName() + " has " + dom3 + " in his hand? " + richie.hasDominoInHand(dom3)); // should be false


        /* Remove double blank from Dwayne's hand */
        System.out.println("\nRemoving " + dom3 + " from " + dwayne.getName() + " hand.");
        dwayne.removeDom(1);

        /* Reprint Dwayne's updated hand */
        System.out.println();
        System.out.println(dwayne.getName() + "'s hand:\n");
        for (Domino dom : dwayne.getHand()) {
            System.out.println(dom);
        }
    }


}
