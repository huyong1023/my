package org.huyong.my.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huyong03
 * @Date: 2022/7/28 11:34
 * @Description:
 */
public class Test {
    public static void main(String args[]) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf("88"));
        String s = strings.get(0);



/*        List<String> stringLists = new List<String>[1];
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList;
        String s = stringLists[0].get(0);*/
    }

    private static void unsafeAdd(List list, Object o) {
        list.add(o);
    }
}
