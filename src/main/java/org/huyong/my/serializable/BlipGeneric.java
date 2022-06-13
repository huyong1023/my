package org.huyong.my.serializable;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 * @Author: huyong03
 * @Date: 2022/6/13 10:53
 * @Description:
 */
public class BlipGeneric  implements Serializable{

    private int i;
    private String s;
    private Color c;
    public BlipGeneric(){
        System.out.println("BlipGeneric no-args constructor");
    }

    public BlipGeneric(String s, int i, Color c){
        System.out.println("BlipGeneric no-args constructor");
        this.s = s;
        this.i = i;
        this.c = c;
    }

    public String toString() {
        return s  + i + c;
    }

    public int getI(){
        return i;
    }

    public String getS(){
        return s;
    }

}
