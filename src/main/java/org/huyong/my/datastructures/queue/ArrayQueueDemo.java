/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/20 17:30
 */
package org.huyong.my.datastructures.queue;

public class ArrayQueueDemo {
}


class ArrayQueue{
    private int maxSize;
    private int front;
    private int real;
    private int[] arr;

    public ArrayQueue(int size){
        maxSize = size;
        arr = new int[size];
        front = -1;
        real = -1;
    }


    public boolean isFull(){
        return  real == maxSize - 1;
    }


    public boolean isEmputy(){
        return front == real;
    }


    public void  addQueue(int value){
        if (isFull()){
            throw  new RuntimeException("queue is full");
        }
        real++;
        arr[real] = value;
    }


    public int getQueue(){
        if (isEmputy()){
            throw new RuntimeException("queue is empty");
        }
        front ++;
        int val = arr[front];
        return front;
    }


    public void showQueue(){
        for (int i = front; i < real; i++){
            System.out.print(i + " ");
        }

    }

    public int headQueue(){
        if (isEmputy()){
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }
}