package org.huyong.my.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class BubbleSort {


    @Test
    public void test(){
        int arr[] = new int[80000];
        for (int i =0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*800000);
        }
        bubbleSort(arr);
    }

    public void bubbleSort(int arr[]){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length - i ; j++){
                if (arr[i] >= arr[j]){
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
}
