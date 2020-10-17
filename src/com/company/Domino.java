package com.company;

public class Domino implements Comparable<Domino>{

    private int bone1;
    private int bone2;
    private boolean flipped;


    public Domino(int bone1, int bone2) {
        this.bone1 = bone1;
        this.bone2 = bone2;
        this.flipped = false;
    }

    public int getBone1() {
        return bone1;
    }

    public int getBone2() {
        return bone2;
    }


    public boolean isFlip(){
        return flipped;
    }

    public void flipDom(){
        flipped = !flipped;
    }



    public boolean isDouble(){
        return bone1 == bone2;
    }


    public int getTotalValue(){
        return bone1 + bone2;
    }

    public boolean isSameValue(Domino compDomino){

        return this.getTotalValue() == compDomino.getTotalValue();

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Domino other = (Domino) obj;
        if (bone1 != other.bone1)
            return false;
        if (bone2 != other.bone2)
            return false;
        return true;
    }

    @Override
    public int compareTo(Domino compDom) {
        return this.getTotalValue() - compDom.getTotalValue();
    }

    @Override
    public String toString() {
        return "[" + bone1 + " | " + bone2 + "]";
    }

}
