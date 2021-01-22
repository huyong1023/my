/**
 * TODO
 *
 * @version 1.0
 * @author huyong03
 * @date 2021/1/21 18:59
 */
package org.huyong.my.datastructures.queue;



public  class CricleArrayQueueDemo implements ArrayQueue {

    private int maxSize;
    private int front;
    private int real;
    private int[] arr;


    CricleArrayQueueDemo(int size){
        if (size < 1){
            throw new RuntimeException("init size must Greater than zero");
        }
        this.maxSize = size + 1;
        arr = new int[maxSize];
        front = 0;
        real = 0;
    }



    @Override
    public boolean isFull() {
        return  (real + 1 ) % maxSize == front;
    }

    @Override

    public boolean isEmpty() {
        return front == real;
    }

    @Override
    public void addQueue(int val) {
        if (isFull()){
            throw new RuntimeException("queue is full");
        }
        arr[real] = val;
        real = (real+1) % maxSize;
    }

    @Override
    public int getQueue() {
        if (isEmpty()){
            throw new RuntimeException("queue is null");
        }
        int val = arr[front];
        front = (front+1) % maxSize;
        return val;
    }

    @Override
    public void showQueue() {
        if (isEmpty()){
            System.out.println("[]");
            return;
        }
        int size =(real - front + maxSize) % maxSize;
        for (int i =0; i < size; i++){
            if (i == 0){
                System.out.print("[");
            } else {
                System.out.print(" ");
            }
            System.out.print(arr[(front + i) % maxSize]);
        }
        System.out.println("]");
    }

    @Override
    public int headQueue() {
        if (isFull()){
            throw new RuntimeException("queue is full");
        }
        return arr[front];
    }
}

