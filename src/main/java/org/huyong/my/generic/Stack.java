package org.huyong.my.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * @Author: huyong03
 * @Date: 2022/7/29 10:21
 * @Description:
 */
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack(){
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }
    public void push(E e){
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null;
        return result;
    }




    public void ensureCapacity(){
        if (elements.length == size){
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
