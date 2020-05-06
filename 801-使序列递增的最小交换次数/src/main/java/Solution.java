/**
 * @author WuBiao
 * @date 2020/5/3 19:52
 */
public class Solution {
    public int minSwap(int[] A, int[] B) {
        int len = A.length;
        if (len < 2) {
            return 0;
        }
        int natural = 0;//表示数组 A 和 B 满足前 i - 1 个元素分别严格递增，并且 A[i - 1] 和 B[i - 1] 未被交换的最小交换次数。
        int swap = 1;//表示数组 A 和 B 满足前 i - 1 个元素分别严格递增，并且 A[i - 1] 和 B[i - 1] 被交换的最小交换次数。
        for (int i = 1; i < len; i++) {
            boolean b1 = (A[i - 1] < A[i] && B[i - 1] < B[i]);
            boolean b2 = (A[i - 1] < B[i] && B[i - 1] < A[i]);
            if (b1 && b2) {
                //A[i],B[i]交不交换无所谓；组合起来有四种情况。
                //如果a[i-1]和b[i-1]没有交换，A[i],B[i]不交换，nature=nature;
                //如果a[i-1]和b[i-1]没有交换，A[i],B[i]交换，swap=natural+1;
                //如果a[i-1]和b[i-1]交换了，A[i],B[i]不交换，nature=swap;
                //如果a[i-1]和b[i-1]交换了，A[i],B[i]也交换，swap=swap+1；
                natural = Math.min(natural, swap);//A[i],B[i]不交换，取最优解
                swap = natural + 1;//A[i],B[i]交换，因为natural已经取了最优解，swap的最优解就是natural+1；
            } else if (b1) {
                //如果a[i-1]和b[i-1]没有交换，A[i],B[i]不用交换，nature=nature;
                //如果a[i-1]和b[i-1]交换了，A[i],B[i]必须交换，swap++；
                swap++;
            } else if (b2) {
                //如果a[i-1]和b[i-1]没有交换,A[i],B[i]必须交换
                int temp = swap;
                swap = natural + 1;
                //如果a[i-1]和b[i-1]交换了，A[i],B[i]不用交换
                natural = temp;
            }
        }
        return Math.min(natural, swap);
    }
}