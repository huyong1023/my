package org.huyong.my.enummodle;

/**
 * @Author: huyong03
 * @Date: 2022/8/3 10:48
 * @Description:
 */
public enum Ensemble {
    SOLO(1), DUET(2), TRIO(3);

    private final int numberOfMusicians;

    Ensemble(int size){
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians(){
        return numberOfMusicians;
    }

    public int orderS(){
        return ordinal();
    }
}
