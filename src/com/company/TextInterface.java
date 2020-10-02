package com.company;

import java.util.Scanner;

public class TextInterface {

    private Scanner input;

    public int numPlayers() {
        System.out.println("How many players today?");
        return input.nextInt();
    }

    public String playerName() {
        System.out.println("Please enter Player's Name.");
        return input.next();
    }
}
