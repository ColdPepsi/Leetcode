/**
 * @author WuBiao
 * @date 2020/3/10 11:11
 */
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;//获取nums的行数
        int n = nums[0].length;//获取nums的列数
        if (m * n != r * c) {
            return nums;
        }
        int[][] newMatrix = new int[r][c];
        int index = 0;//用index来定位当前nums元素的下标
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newMatrix[i][j] = nums[index / n][index % n];
                index++;
            }
        }
        return newMatrix;
    }
}