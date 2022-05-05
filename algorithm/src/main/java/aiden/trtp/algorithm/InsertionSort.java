package aiden.trtp.algorithm;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-23 15:40
 **/
public class InsertionSort {

    /**
     * @throws
     * @Description: 插入排序，0-0有序，0-i 想有序，跟前一个比较，无序则交换位置
     * @Param [arr]
     * @return: void
     * @Author: jiangyunhao
     * @Date: 2022/4/23 4:12 下午
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //0跟自己比较必然有序，从1开始
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (100 * Math.random());
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        InsertionSort.insertionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
