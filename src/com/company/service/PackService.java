package com.company.service;

import com.company.objects.Domino;
import com.company.objects.Pack;
import com.company.objects.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PackService {



    public int packSize(ArrayList<Pack> pack) {
        return pack.size();
    }


    public void addToHand(Pack pack, Player player, int numOfDominoes){
        int size = pack.getPack().size();
        for (int i = size - 1; i > size - 1 - numOfDominoes; i--) {
            player.addDomino(pack.getPack().remove(i));
        }


    }


}
