/**
 * @author WuBiao
 * @date 2020/3/11 9:35
 */
public class Solution {
    /**
     * @param matrix
     * @param target
     * @return boolean
     * @description 从左下角向右上角寻找。
     * @author WuBiao
     * @date 2020/3/11 12:03
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int col = 0;
        //从左下角开始寻找
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;//不会出现col--的情况，因为走到某点的时候，某点的左上方区域已经全被淘汰
            } else {
                return true;
            }
        }
        return false;
    }
}