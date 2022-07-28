package org.huyong.my.object;

/**
 * @Author: huyong03
 * @Date: 2022/7/6 12:09
 * @Description:
 */
public class CloneableObject implements Cloneable {



    public static void main(String args[]){
        CloneableObject o = new CloneableObject();
        try {
            CloneableObject object = (CloneableObject) o.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
