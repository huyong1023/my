package org.huyong.my.jvm.oom;

/**
 * Created by yonghu on 2020/5/27.
 */
public class StackOOM {
    private  void fun(){
        fun();
    }

    public static void main(String args[]){
        StackOOM stackOOM = new StackOOM();
        stackOOM.fun();
    }
}
