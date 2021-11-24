package org.huyong.my;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        String s2 = "123";
        String  s = new String("123").intern();
        System.out.println(s2 == s);

    }
}
