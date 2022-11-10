package org.huyong.my.datastructures.sort;

public class QuickSort {


    public void quickSort(int arr[], int left, int right){
        int pivot = arr[(left + right)/2];
        int l = left;
        int r = right;

        while (l < r){
            if (arr[l] < pivot){
                l++;
            }
            if (arr[r] > pivot){
                r--;
            }

            if (l > r ){
                break;
            }

            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;

            if (arr[l] == pivot){
                r--;
            }

            if (arr[r] == pivot){
                l++;
            }

            if (l == r){
                l ++;
                r--;
            }

            if (l < right){
                quickSort(arr, l, right);
            }

            if (r > left){
                quickSort(arr, left, r);
            }
        }

    }
}
