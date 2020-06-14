/**
 * @author WuBiao
 * @date 2020/6/14 23:47
 */
public class Solution {
    public int findBestValue(int[] arr, int target) {
        int len = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
            sum += i;
        }
        if (sum <= target) {// sum小于等于target，已经无济于事，直接返回最大值，所有数都不用修改
            return max;
        }
        int avg = target / len;
        if (min >= avg) {//最小值都大于avg，返回avg，所有数都需要修改。
            int temp = (avg + 1) * len;
            return temp - target > target - avg * len ? avg : avg + 1;
        }
        //执行到这里 sum>target，且根据value的取值，sum会一直减小
        // value取avg的时候，sum会直接小于target，所以value最小值就是avg，没必要再小，再小的话没必要，sum会更小
        sum = getSum(arr, avg);
        while (sum < target) {
            int nextSum = getSum(arr, avg + 1);
            if (nextSum >= target) { //nextSum >= target > sum,此时结果必然在avg和avg+1中产生
                return nextSum - target >= target - sum ? avg : avg + 1;
            }
            sum = nextSum;
            avg++;
        }
        return 0;
    }

    private int getSum(int[] arr, int value) {
        int sum = 0;
        for (int i : arr) {
            sum += Math.min(i, value);
        }
        return sum;
    }
}
