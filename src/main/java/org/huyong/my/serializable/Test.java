package org.huyong.my.serializable;

import java.io.*;

/**
 * @Author: huyong03
 * @Date: 2022/6/13 10:54
 * @Description:
 */
public class Test {

    public static void main(String args[]) throws IOException, ClassNotFoundException {

        BlipGeneric bgeneric = new BlipGeneric("BlipGeneric", 2, Color.GREEN);
        Blip b = new Blip("Blip", 1, bgeneric, Color.RED);


        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(b);


        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(in);
        Blip bb = (Blip) ois.readObject();
        System.out.println(bb.toString());



/*        ByteArrayOutputStream out2 = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(out2);
        oos2.writeObject(bgeneric);

        ByteArrayInputStream in2 = new ByteArrayInputStream(out2.toByteArray());
        ObjectInputStream ois2 = new ObjectInputStream(in2);

        BlipGeneric bbgeneric = (BlipGeneric) ois2.readObject();
        System.out.println(bbgeneric.toString());*/



    }
}
