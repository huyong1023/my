package org.huyong.my.algorithm.stack;

/**
 * Created by yonghu on 2020/6/18.
 */
public class ArrayStackDemo {
}

class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }


    public boolean isEmpty() {
        return top == -1;
    }

}