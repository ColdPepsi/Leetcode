/**
 * @author WuBiao
 * @date 2020/6/6 10:55
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] res = new int[matrix.length * matrix[0].length];
        //声明上下左右4个边界
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        int index = 0;
        while (true) {
            for (int i = left; i <= right; i++) {//输入最上面一行
                res[index++] = matrix[top][i];
            }
            if (top++ >= bottom) {
                break;
            }
            for (int i = top; i <= bottom; i++) {//输入最右边一行
                res[index++] = matrix[i][right];
            }
            if (right-- <= left) {
                break;
            }
            for (int i = right; i >= left; i--) {//输入最下面一行
                res[index++] = matrix[bottom][i];
            }
            if (bottom-- <= top) {
                break;
            }
            for (int i = bottom; i >= top; i--) {//输入最左边一行
                res[index++] = matrix[i][left];
            }
            if (left++ >= right) {
                break;
            }
        }
        return res;
    }
}