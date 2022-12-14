package org.huyong.my.datastructures.sort;

import org.junit.Test;

import java.util.Arrays;

public class ShellSort {


    @Test
    public void test(){
        int arr[] = new int[80000];
        for (int i =0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*800000);
        }
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void shellSort(int arr[]){
        int len = arr.length;
        for (int gap = len/2; gap > 0; gap = gap/2 ){
            for (int i = gap; i < len; i++){
                for (int j = i - gap; j >= 0; j -= gap){
                    if (arr[j] > arr[j + gap]){
                        int tmp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }
    }
}
