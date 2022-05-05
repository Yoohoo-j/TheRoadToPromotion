package aiden.trtp.algorithm;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-24 17:30
 **/
public class MergeSort {

    public static void mergeSort(int[] arr){
        if (arr == null || arr.length == 0){
            return ;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int left, int right) {
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        process(arr, left, mid);
        process(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= right){
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
    }
    
    /**
     * @Description: 求小和
     * @Param [arr]
     * @return: int
     * @Author: jiangyunhao
     * @Date: 2022/4/24 7:11 下午
     * @throws
    */
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return processSum(arr, 0, arr.length - 1);
    }

    private static int processSum(int[] arr, int left, int right) {
        if (left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return processSum(arr, left, mid) + processSum(arr, mid + 1, right) + mergeSum(arr, left, mid, right);
    }

    private static int mergeSum(int[] arr, int left, int mid, int right) {
        int[] help = new int[right - left + 1];
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        int sum = 0;
        while (p1 <= mid && p2 <= right){
            sum += arr[p1] < arr[p2] ? (right - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid){//左组没越界的
            help[i++] = arr[p1++];
        }
        while (p2 <= right){//右组没越界的
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++){
            arr[left + i] = help[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = new int[20];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (100 * Math.random());
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
        System.out.println(MergeSort.smallSum(arr));

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
