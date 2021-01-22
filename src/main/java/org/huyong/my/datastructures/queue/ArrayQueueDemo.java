/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/20 17:30
 */
package org.huyong.my.datastructures.queue;


public class ArrayQueueDemo implements ArrayQueue {
    private int maxSize;
    private int front;
    private int real;
    private int[] arr;

    public ArrayQueueDemo(int size){
        maxSize = size;
        arr = new int[size];
        front = -1;
        real = -1;
    }


    public boolean isFull(){
        return  real == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
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
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        front ++;
        int val = arr[front];
        return val;
    }


    public void showQueue(){
        System.out.print( "[");
        if (isEmpty()) {
            System.out.println("]");
            return;
        }

        for (int i = front + 1; i <= real; i++){
            if (i != front + 1){
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println("]");

    }

    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("queue is empty");
        }
        return arr[front + 1];
    }
}