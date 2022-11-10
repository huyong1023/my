package org.huyong.my.collections;


import java.util.*;

/**
 * @Author: huyong03
 * @Date: 2022/6/8 14:51
 * @Description:
 */
public class Demo {

    public static void main(String args[]){

        List<String> str = Arrays.asList("1,2,3,4".split(","));
        String check = "1";

        int frequency = Collections.frequency(str, check);

        EnumSet e1 = EnumSet.allOf(Session.class);
        System.out.println(e1);

        Session e = Session.valueOf("SPRING");
        System.out.println(e.ordinal());


        EnumSet e2 = EnumSet.noneOf(Session.class);
        e2.add(Session.SPRING);
        e2.add(Session.SUMMER);
        System.out.println(e2);

        EnumSet e3 = EnumSet.of(Session.SPRING, Session.FAIL);
        System.out.println(e3);

        EnumSet e4 = EnumSet.range(Session.SPRING, Session.FAIL);
        System.out.println(e4);


        EnumSet e5 = EnumSet.complementOf(e4);
        System.out.println(e5);


    }
}

enum Session{
    SPRING,
    SUMMER,
    FAIL,
    WINTER
}



