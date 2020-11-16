package com.company;

import com.company.objects.Game;
import com.company.service.GameService;

public class Main {

    public static void main(String[] args) {
        //Game g = new Game();
        GameService svc = new GameService();
        Game g = svc.generateGame(2);
        svc.play(g);
        //Test.playGame();
    }
}
