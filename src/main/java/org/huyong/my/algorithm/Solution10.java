package org.huyong.my.algorithm;

public class Solution10 {
    private String s1, s2;
    private int n1, n2;
    private boolean[][] r;

    public boolean isMatch(String s, String p) {
        s1 = s;
        s2 = p;
        n1 = s.length();
        n2 = p.length();

        r = new boolean[n1 + 1][n2 + 1];
        System.out.println(n1 + " " +n2);
        r[0][0] = true;

        isMatch(1,1);

        System.out.print("    ");
        for (int i = 0; i < n2; i++){
            System.out.print(s.charAt(i) + " ");
        }
        System.out.println();

        for (int j = 0; j <= n2; j++){
            if (j != 0) {
                System.out.print(p.charAt(j - 1) + " ");
            } else {
                System.out.print("  ");
            }
            for (int i = 0; i <= n1; i++) {
                if (r[i][j]){
                    System.out.print("T");
                } else {
                    System.out.print("F");
                }
                System.out.print( " ");
            }
            System.out.println();
        }


        return r[n1][n2];
    }


    public void isMatch(int sn1, int sn2){
        System.out.println(sn1+ " -- " + sn2);
        if(sn1 <=n1 && sn2 <= n2 && r[sn1][sn2]){
            return;
        }
        if (sn1 < 1 || sn2 < 1 || sn1 > n1 || sn2 > n2 ){
            if (sn1 == n1 + 1 && sn2 <=n2 ){
                char c2 = s2.charAt(sn2-1);
                System.out.println(sn1+ " -- " + sn2 + " -- " + c2);
                if (c2 == '*'){
                    r[sn1-2][sn2] = r[sn1-2][sn2-2];
                    if (r[sn1-2][sn2]) {
                        isMatch(sn1 - 1, sn2 + 1);
                    }

                    r[sn1-1][sn2] = r[sn1-1][sn2-1];
                    if (r[sn1-1][sn2] ){
                        isMatch(sn1 , sn2 + 1);
                    }
                }
                isMatch(sn1 + 1, sn2 + 1);

            } else if(sn1 == n1 + 2 && sn2 <=n2 ){

                char c2 = s2.charAt(sn2-1);
                System.out.println(sn1+ " || " + sn2 + " || " + c2);
                if (c2 == '*'){
                    r[sn1-2][sn2] = r[sn1-2][sn2-2];
                    if (r[sn1-2][sn2]) {
                        isMatch(sn1 - 1, sn2 + 1);
                    }

                }
                isMatch(sn1 + 1, sn2 + 1);
            }

            return;
        }
        char c1 = s1.charAt(sn1-1);
        char c2 = s2.charAt(sn2-1);
        if ( r[sn1-1][sn2-1] && (c1 == c2 || c2 == '.')){
            r[sn1][sn2] = true;
        } else if (c2 == '*'){

            System.out.println(sn1+ " || " + sn2 + " || " + c2);
            r[sn1-2][sn2] = r[sn1-2][sn2-2];
            r[sn1-1][sn2] = r[sn1-1][sn2-1];

            c2 = s2.charAt(sn2-2);
            for (int i = 0; i <= n1 - sn1; i++){
                System.out.println(sn1+ " ||* " + (sn2 - 2) + r[sn1 + i][sn2-2] +" || " + c2);
                if (sn2 > 2 && r[sn1 + i][sn2-2]){
                    r[sn1 + i][sn2] = true;
                    //isMatch(sn1 + i + 1, sn2 + 1);
                } else {
                    c1 = s1.charAt(sn1 - 1 + i);
                    if (r[sn1 - 1 + i][sn2] && (c1 == c2 || c2 == '.')) {
                        r[sn1 + i][sn2] = true;
                        //isMatch(sn1 + i + 1, sn2 + 1);
                    } else if (c2 == '*') {

                    }
                }
            }


            for(int i = n1; i >= sn1 - 2; i--){
                System.out.println();
                if (r[i][sn2]){
                    isMatch(i+1 , sn2 + 1);
                }
            }







        }
        isMatch(sn1 + 1, sn2 + 1);
    }


    public static  void main(String args[]){
/*        String s1 = "cbaacacaaccbaabcb";
        String s2 = "c*b*b*.*ac*.*bc*a*";*/
        String s1 = "bbcacbabbcbaaccabc";
        String s2 = "b*a*a*.c*bb*b*.*.*";


        Solution10 solution = new Solution10();
        System.out.println(solution.isMatch(s1, s2));
    }

}
