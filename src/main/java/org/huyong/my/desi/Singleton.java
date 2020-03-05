package org.huyong.my.desi;

/**
 * Created by yonghu on 2019/11/6.
 */
public class Singleton {
    private Singleton (){

    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance (){
        return instance;
    }

}
