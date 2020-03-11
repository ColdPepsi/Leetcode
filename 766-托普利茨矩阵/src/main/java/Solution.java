/**
 * @author WuBiao
 * @date 2020/3/11 20:36
 */
public class Solution {
    /**
     * @param matrix
     * @return boolean
     * @description 直接和左上角比较
     * @author WuBiao
     * @date 2020/3/11 20:48
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {//跳过每行每列的第一个元素
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}