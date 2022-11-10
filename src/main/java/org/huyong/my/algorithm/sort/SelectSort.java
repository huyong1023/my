package org.huyong.my.algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

public class SelectSort {

    @Test
    public void test(){
        int arr[] = new int[80000];
        for (int i =0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*800000);
        }

        //System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));


    }


    public void selectSort(int arr[]){
        for (int i =0; i < arr.length; i++){
            int temp = arr[i], tempIndex = i;
            for (int j = i +1; j < arr.length; j++){
                if (temp > arr[j]){
                    temp = arr[j];
                    tempIndex = j;
                }
            }
            arr[tempIndex] = arr[i];
            arr[i] = temp;
        }
    }

}
