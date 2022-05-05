package aiden.trtp.algorithm;

import static com.sun.tools.javac.jvm.ByteCodes.ret;
import static com.sun.tools.javac.jvm.ByteCodes.swap;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-25 13:58
 **/
public class QuickSort {

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            swap(arr, left + (int) (Math.random() * (right - left + 1)), right);//随机选择一个数作为分区标准
            int[] p = partition(arr, left, right);//分成三部分 < = >
            quickSort(arr, left, p[0] - 1);//小于区进递归
            quickSort(arr, p[1] + 1, right);//大于区进递归
        }
    }

    private static int[] partition(int[] arr, int left, int right) {
        int less = left - 1; // <区右边界
        int more = right; // >区左边界 以最后一个数做划分值
        while (left < more) { // left 表示当前需要比较的数 的位置
            if (arr[left] < arr[right]) { //跟最后一个数比较，小于
                swap(arr, ++less, left++); // 小于区右扩，当前下标到下一个数，跟小于区前一个换
            } else if (arr[left] > arr[right]) { // 当前值大于划分值
                swap(arr, --more, left); // 大于区做扩，大于区前一个值跟当前值做交换
            } else { // 当前值等于划分值
                left++; // 不动，下标到下一个
            }
        }
        swap(arr, more, right); //比较完以后，把R位置的数，调整到等于区域的右边
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int randomIndex, int right) {
        int tmp = arr[randomIndex];
        arr[randomIndex] = arr[right];
        arr[right] = tmp;
    }
}
