/**
 * @author WuBiao
 * @date 2020/3/11 12:30
 */
public class Solution {
    /**
     * @param matrix
     * @param k
     * @return int
     * @description 二分查找，找出二维矩阵中最小的数left，最大的数right，那么第k小的数必定在left~right之间
     * 2.mid=(left+right) / 2；在二维矩阵中寻找小于等于mid的元素个数count
     * 若这个count小于k，表明第k小的数在右半部分且不包含mid，即left=mid+1, right=right
     * @author WuBiao
     * @date 2020/3/11 13:11
     */
    public int kthSmallest(int[][] matrix, int k) {
        //left、right、mid均为值，非下标
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];//最小值
        int right = matrix[row - 1][col - 1];//最大值
        while (left < right) {
            int mid = (left + right) / 2;
            int count = findCountNotBiggerThanMid(matrix, mid, row, col);
            if (count < k) {//落在右区间
                left = mid + 1;
            } else {
                right = mid;//左区间可能包含mid
            }
        }//保证k总是在left和right中间，跳出循环的时候left=right
        return left;
    }

    /**
     * @param matrix
     * @param mid
     * @param row
     * @param col
     * @return int
     * @description 找到矩阵中有多少个元素，不大于mid
     * @author WuBiao
     * @date 2020/3/11 13:22
     */
    private int findCountNotBiggerThanMid(int[][] matrix, int mid, int row, int col) {
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col && matrix[i][j] <= mid; j++) {
                count++;
            }
        }
        return count;
    }
}