package org.huyong.my.datastructures.tree;

/**
 * Created by yonghu on 2020/6/23.
 */
public class ArrBinaryTreeDemo {
}



class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr){
        this.arr = arr;
    }

    public void preOrder(){
        this.preOrder(0);
    }

    public void preOrder(int index) {
        if(arr == null || arr.length == 0){

        }
        System.out.println(arr[index]);
        if((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }

        if((index * 2 + 2) < arr.length) {
            preOrder(2*index + 2);
        }
    }
}