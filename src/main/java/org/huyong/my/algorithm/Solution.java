package org.huyong.my.algorithm;

public class Solution {
    public int numDecodings(String s) {
        if (null == s || "".equals(s) || "0".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int[] map = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            map[i] = -1;
        }
        return count(chars, chars.length, 0, map);
    }

    public int count(char[] chars, int length, int index, int[] map) {
        if (length - 1 < index) {
            return 1;
        }

        if (chars[index] == '0') {
            return 0;
        }
        int res = count(chars, length, index + 1, map);
        if (map[index] != -1)
            return map[index];
        if (index < length - 1 && ((chars[index] - '0') * 10 + (chars[index + 1] - '0') < 27)) {
            res += count(chars, length, index + 2, map);
        }
        map[index] = res;
        return res;
    }


    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.numDecodings("12"));
    }
}
