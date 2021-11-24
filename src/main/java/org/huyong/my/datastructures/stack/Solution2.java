package org.huyong.my.datastructures.stack;

import java.util.*;

public class Solution2 {


    public static void main(String[] args) {
        String expression = "(1+(4+5+2)-3)+(6+8)";

        Solution2  solution2 = new Solution2();
        int re = solution2.calculate(expression);
        System.out.println(re);

    }


    public int calculate(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());


        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();


        for (String item : ls) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && getValue(s1.peek()) >= getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }


        while (s1.size() != 0) {
            s2.add(s1.pop());
        }

        Stack<String> stack = new Stack<String>();

        for (String item : s2) {
            if (item.matches("\\d+")) {
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push("" + res);
            }
        }

        return Integer.parseInt(stack.pop());


    }


    public int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = 1;
                break;
            case "-":
                result = 1;
                break;
            case "*":
                result = 2;
                break;
            case "/":
                result = 2;
                break;
            default:
                break;
        }
        return result;
    }
}
