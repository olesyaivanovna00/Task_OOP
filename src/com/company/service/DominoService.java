package com.company.service;

import com.company.objects.Domino;

public class DominoService {

    public boolean isDouble(Domino d){
        return d.getBone1() == d.getBone2();
    }

    public int getTotalValue(Domino d){
        return d.getBone1() + d.getBone2();
    }

    /**
     * @param d1 - первый элемент
     * @param d2 - добавляемый
     * @return 1 - если добавлям, не меняя; 0 - не добавляем; -1 - если добавялем, но меняем местами
     */
    public int toLeft(Domino d1, Domino d2){ //в начало
        if (d1.getBone1() == d2.getBone2()){
            return 1;
        } else if (d1.getBone1() == d2.getBone1()){
            return -1;
        } else {
            return 0;
        }
    }


    /**
     * @param d1 - последний элемент
     * @param d2 - добавляемый
     * @return 1 - если добавлям, не меняя; 0 - не добавляем; -1 - если добавялем, но меняем местами
     */
    public int toRight(Domino d1, Domino d2){ //в конец
        if (d1.getBone2() == d2.getBone1()){
            return 1;
        } else if (d1.getBone2() == d2.getBone2()){
            return -1;
        } else {
            return 0;
        }
    }

}
