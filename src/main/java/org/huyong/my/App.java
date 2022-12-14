package org.huyong.my;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        int a = 10;
        long b = 10l;
        double c = 10.0;
        System.out.print(a ==b);
        System.out.print(a ==c);
        System.out.print(c ==b);


        Map m = new HashMap();

        Map m2 = new Hashtable();

        StringBuffer sb = new StringBuffer();

        StringBuilder builder = new StringBuilder();


    }
}
