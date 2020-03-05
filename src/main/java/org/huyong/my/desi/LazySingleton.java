package org.huyong.my.desi;

/**
 * Created by yonghu on 2019/11/6.
 */
public class LazySingleton {
    private LazySingleton (){

    }

    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance (){
        if (instance == null ){
            instance = new LazySingleton();
        }

        return  instance;
    }
}
