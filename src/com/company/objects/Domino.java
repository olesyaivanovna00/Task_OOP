package com.company.objects;

public class Domino{

    private int bone1;
    private int bone2;


    public Domino(int bone1, int bone2) {
        this.bone1 = bone1;
        this.bone2 = bone2;
    }

    public int getBone1() {
        return bone1;
    }

    public int getBone2() {
        return bone2;
    }

    public void reverse(){
        this.bone1 = bone2 + bone1;
        this.bone2 = bone1 - bone2;
        this.bone1 = bone1 - bone2;
    }

    @Override
    public String toString() {
        return "[" + bone1 + " | " + bone2 + "]";
    }


}
