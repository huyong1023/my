package org.huyong.my.serializable;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author: huyong03
 * @Date: 2022/6/13 10:35
 * @Description:
 */
public class Blip implements Externalizable {



    private int i;
    private String s;
    private BlipGeneric blipGeneric;
    private Color c;
    public Blip(){
        System.out.println("Bilp no-args constructor");
    }

    public Blip(String s, int i, BlipGeneric blipGeneric, Color c){
        System.out.println("Blip with args constructor");
        this.s = s;
        this.i = i;
        this.blipGeneric = blipGeneric;
        this.c = c;
    }

    public String toString() {
        return s  + i + c + blipGeneric ;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("call writeExternal");
        out.writeObject(s);
        out.writeInt(i);
        out.writeObject(blipGeneric);
        out.writeObject(c);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("call readExternal");
        s = (String) in.readObject();
        i = in.readInt();
        blipGeneric = (BlipGeneric)in.readObject();
        c = (Color) in.readObject();
    }
}
