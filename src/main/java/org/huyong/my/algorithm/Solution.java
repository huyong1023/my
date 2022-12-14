package org.huyong.my.algorithm;

import org.junit.Test;

import java.util.*;

public class Solution {


    @Test
    public void test(){
        int[] s = {1,2};
        int[] rs = {3,4};;

        System.out.println(rotatedDigits(10));
    }



    public int rotatedDigits(int n) {

        int[] d = {0, 0 , 1 , -1 , -1, 1, 1, -1 , 0, 1};

        int count = 0;
        for (int i =0; i < n; i ++){
            int check = i;
            boolean needNot = true, need = false;
            while (check > 0){
                int t = check % 10;
                check = check / 10;
                if (d[t] == -1){
                    needNot = false;
                    break;
                } else if (d[t] == 1){
                    need = true;
                }
            }
            if (needNot && need){
                count++;
            }
        }
        return count;
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int len2 = nums2.length;
        int flag = (len + len2) % 2;
        int lenn = (len + len2) / 2 + flag + 1;
        int[] newn = new int[lenn];
        int j = 0, k =0;
        for (int i = 0; i < nums1.length; i++){

            if ( (i == len -1)){

            }else
            while ((nums1[i] > nums2[j] && j < lenn -1)){
                newn[k] =  nums2[j];
                k++;
                j++;
            }
            newn[k] = nums1[i];
            k++;
            if (k >= lenn){
                break;
            }
        }
        System.out.println(Arrays.toString(newn));
        if (flag == 0){
            return  (newn[lenn -2] + newn[lenn -1]) / 2 ;

        } else {
            return newn[lenn -1];
        }


    }


    public int[] decrypt(int[] code, int k) {
        int[] re = new int[code.length];
        for (int i = 0; i < code.length; i++){
            if (k > 0){
                for (int j = 1; j <= k; j++){
                    int index =  i + j;
                    if (index >= code.length){
                        index = index - code.length;
                    }
                    re[i] = re[i] + code[index];
                }
            } else if (k < 0){
                for (int j = 1; j <= -k ; j++){
                    int index = i - j ;
                    if (index < 0){
                        index = index + code.length;
                    }
                    re[i] = re[i] + code[index];
                }
            }
        }
        return re;
    }



    public int lengthOfLongestSubstring(String s) {
        Set<Character> ss = new LinkedHashSet<>();
        int len = s.length();
        int ci = 0, ans =0;
        for(int i = 0; i < len; i++){
            if (i != 0){
                ss.remove(s.charAt(i-1));
            }
            while (ci < len && !ss.contains(s.charAt(ci))){
                ss.add(s.charAt(ci));
                ci++;

            }
            ans = Math.max(ans, ci - i);
        }
        return ans;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while(l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }








    @Test
    public void canFormArray() {

        int[] arr =  {91,4,64,78};
        int[][] pieces = {{78}, {4,64}, {91}};
        int n = arr.length, m = pieces.length;
        Map<Integer, Integer> index = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            index.put(pieces[i][0], i);
        }


        for(int i = 0; i < n; i++){
            if(index.containsKey(arr[i])){
                int s = index.get(arr[i]);
                for (int j = 0; j < pieces[s].length; j++){
                    if (arr[i + j] != pieces[s][j]){
                        System.out.println(i + "return false;" +  s);
                    }
                }
                i = i + pieces[s].length -1;
            } else {

                System.out.println("return  sfalse;" + arr[i] + i);
            }
        }

        System.out.println("return true;");
    }



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
        if (length - 1 < index)
            return 1;
        if (chars[index] == '0')
            return 0;

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

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
