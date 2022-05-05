package aiden.trtp.algorithm;

import java.util.Arrays;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-23 12:39
 **/
public class SelectionSort {

    public static void selectionSort(int[] arr){
        if (arr.length < 2 || arr == null){
            return;
        }
        for (int i = 0; i < arr.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){//找到i后面最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0 ; i < arr.length;i++){
            arr[i] = (int)(20 * Math.random());
        }
        SelectionSort.selectionSort(arr);
        for (int i = 0; i< arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
