package org.huyong.my.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class InsertSort {

    @Test
    public void test(){
        int arr[] = new int[80000];
        for (int i =0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*800000);
        }
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public void insertSort(int arr[]){
        for (int i = 1; i < arr.length; i++){

            int index = i;
            int val = arr[index] ;

            while ( (index > 0) && ( arr[index -1]> val)){
                arr[index] = arr[index -1 ];
                index--;
            }
            arr[index] = val;
        }

    }
}
