/**
 * @author wubiao21 2020年07月09日 10:53:57
 */
public class Solution {

    /**
     * 如果矩阵某元素为0，则把该行和该列首元素标记为0
     *
     * @param matrix 矩阵
     */
    public void setZeroes(int[][] matrix) {
        boolean firstColFlag = false;//matrix[0][0]标记第0行是否有0，新申请一个变量，来标记第0列是否有0
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        for (int i = 0; i < rowLen; i++) {
            if (matrix[i][0] == 0) {
                firstColFlag = true;
            }
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {//如果矩阵某元素为0，则把该行和该列首元素标记为0
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowLen; i++) {//从第2行第2列开始判断
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (matrix[0][0] == 0) {//处理第1行
            for (int i = 0; i < colLen; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstColFlag) {//处理第1列
            for (int i = 0; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}