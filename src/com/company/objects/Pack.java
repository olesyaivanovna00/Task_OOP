package com.company.objects;

import com.company.objects.Domino;
import com.company.objects.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Pack {
    private List<Domino> pack;

    public Pack() {

        pack = new ArrayList<>();

        for(int i = 0; i <= 6; i++) {
            for(int k = i; k <= 6; k++) {
                Domino newDom = new Domino(i,k);
                pack.add(newDom);
            }
        }
    }

    public List<Domino> getPack() {
        return pack;
    }

    public void remove(Domino d){
        pack.remove(d);
    }


}
