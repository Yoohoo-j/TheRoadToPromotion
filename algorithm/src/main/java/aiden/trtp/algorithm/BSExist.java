package aiden.trtp.algorithm;

/**
 * @program: TheRoadToPromotion
 * @description:
 * @author: Mr.Jiang
 * @create: 2022-04-23 16:44
 **/
public class BSExist {

    /**
     * @throws
     * @Description: 二分查找，基于有序数组，时间复杂度O（logN）。
     * 确定mid,值大于mid，左边界mid + 1，值小于mid，由边界mid -1
     * @Param [sortedArr, num]
     * @return: boolean
     * @Author: jiangyunhao
     * @Date: 2022/4/23 4:55 下午
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortedArr.length - 1;
        int mid = 0;
        while (l < r) {
            mid = l + ((r - l) >> 1);//(l + r) / 2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return sortedArr[l] == num;
    }

    /**
     * @throws
     * @Description: 找到大于等于num最左的位置，要二分到结束，返回最左侧的位置
     * @Param [sortedArr, num]
     * @return: int
     * @Author: jiangyunhao
     * @Date: 2022/4/23 5:27 下午
     */
    public static int nearLeftIndex(int[] sortedArr, int num) {
        int l = 0;
        int r = sortedArr.length - 1;
        int index = -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (sortedArr[mid] >= num) {
                index = mid;
                r = mid - 1;//存在大于等于的数，还在继续在左边找
            } else {
                l = mid + 1;//如果没有大于等于的数，在右边找
            }
        }
        return index;
    }

    public static int localMinimumindex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1 || arr[0] < arr[1]) { // 前面的趋势是从大到小，则需要继续查找
            return 0; //否则第一个就是局部最小
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) { // 后面从后往前趋势是从大到小，则需要继续查找
            return arr.length - 1; //否则最后一个就是局部最小
        }
        int l = 1;
        int r = arr.length - 2;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (arr[mid] > arr[mid - 1]) {
                r = mid - 1; //局部最小在左边
            } else if (arr[mid] > arr[mid + 1]) {
                l = mid + 1; // 局部最小在右边
            } else {
                return mid;
            }
        }
        return l;
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
        System.out.println("\n" + BSExist.exist(arr, 85));
    }
}