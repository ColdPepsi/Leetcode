/**
 * 类Solution2.java的实现描述：先二分搜索行，再二分搜索列
 *
 * @author wubiao21 2020年07月10日 16:46:46
 */
public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;//左上角和右下角是极值
        }
        int left = 0;
        int right = matrix.length;
        while (left < right) {//找到第一个大于target的值
            int mid = (left + right) / 2;
            if (matrix[mid][0] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int currentRow = left - 1;
        left = 0;
        right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[currentRow][mid] == target) {
                return true;
            } else if (matrix[currentRow][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}