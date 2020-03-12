/**
 * @author WuBiao
 * @date 2020/3/12 22:16
 */
public class Solution {
    /**
     * @param numbers
     * @param target
     * @return int[]
     * @description 控制两端指针即可
     * @author WuBiao
     * @date 2020/3/12 22:21
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null) {
            return null;
        }
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }
}