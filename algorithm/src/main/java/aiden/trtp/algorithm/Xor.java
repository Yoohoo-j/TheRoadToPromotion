package aiden.trtp.algorithm;

/**
 * @program: TheRoadToPromotion
 * @description: 异或
 * @author: Mr.Jiang
 * @create: 2022-04-23 18:11
 **/
public class Xor {

    /**
     * @Description: 一组数的某个数出现了奇数次，其他数出现了偶数次
     * 用异或实现，数组中的顺序不影响最终结果，结果只与每一位上的值（0 或 1）的个数有关
     * @Param [arr]
     * @return: void
     * @Author: jiangyunhao
     * @Date: 2022/4/23 6:47 下午
     * @throws
    */
    public static void printOddTimesNum(int[] arr){
        int eor = 0;
        for (int i = 0; i< arr.length; i++){
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    public static void printOddTimes2Num(int[] arr){
        int eor = 0;
        for (int i =0; i< arr.length; i++){
            eor ^= arr[i]; // eor = a ^ b 出现偶数次的数异或后都为0
        }
        // a 或 b 的某一位肯定不一样，eor肯定有一位为1， 可以把整个数组分两类某一位为0或某一位为1
        int rightOne = eor & (~eor + 1);// 取最右的1 ， 001000110100 取反110111001011 （+1）110111001100 & 000000000100
        int onlyOne = 0;
        for (int cur :arr){
            if ((cur & rightOne) != 0){ //找出a 或 b所在的组
                onlyOne ^= cur;//因为交换律和结合律 偶数个异或后都为0，onlyOne就是两个奇数次数的其中一个
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    public static void main(String[] args) {
        int[] arr = {4,5,23,4,1,23,5,1,1,5,6,6};
        printOddTimes2Num(arr);
    }
}
