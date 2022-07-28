package org.huyong.my;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {

        String s1 = "123";
        String s2 = new String("123").intern();
        String s3 = new String("123");
        String s4 = "123";
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);

    }
}
