package org.huyong.my.desi;

/**
 * Created by yonghu on 2019/11/6.
 */
public class StaticSingleton {

    private StaticSingleton (){

    }

    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    public static StaticSingleton getInstance (){
        return SingletonHolder.instance;
    }

}



