package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pack {
    private List<Domino> pack;

    public Pack() {

        pack = new ArrayList<Domino>();

        for(int i = 0; i <= 6; i++) {
            for(int k = i; k <= 6; k++) {
                Domino newDom = new Domino(i,k);
                pack.add(newDom);
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(pack);
    }

    public int packSize() {
        return pack.size();
    }


    public void addToHand(Player player, int numOfDomino) {

        for(int i = 0; i < numOfDomino; i++) {

            /* Take the first domino from the pack,
             * and put it in the given player's hand.*/
            player.addDomino(pack.remove(0));

        }

    }
}
