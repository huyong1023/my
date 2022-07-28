package org.huyong.my.serializable;

/**
 * @Author: huyong03
 * @Date: 2022/6/13 19:58
 * @Description:
 */
public class Outter {
    private Inner inner = null;
    private String s = "out";

    public Outter(){

    }

    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    class Inner{
        private String s = "inner";

        public void s(){
            System.out.println(s);
        }

    }
}
