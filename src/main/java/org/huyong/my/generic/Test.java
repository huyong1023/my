package org.huyong.my.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huyong03
 * @Date: 2022/7/28 11:34
 * @Description:
 */
public class Test {
    public static void main(String args[]){
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf("88"));
        String s = strings.get(0);
    }

    private static void unsafeAdd(List list, Object o){
        list.add(o);
    }
}
