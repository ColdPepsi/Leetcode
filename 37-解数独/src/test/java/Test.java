/**
 * @author WuBiao
 * @date 2020/4/13 17:59
 */
public class Test {
    Solution solution=new Solution();
    public char[][] nums={{'.','.','9','7','4','8','.','.','.'},
            {'7','.','.','.','.','.','.','.','.'},
            {'.','2','.','1','.','9','.','.','.'},
            {'.','.','7','.','.','.','2','4','.'},
            {'.','6','4','.','1','.','5','9','.'},
            {'.','9','8','.','.','.','3','.','.'},
            {'.','.','.','8','.','3','.','2','.'},
            {'.','.','.','.','.','.','.','.','6'},
            {'.','.','.','2','7','5','9','.','.'}};
    @org.junit.Test
    public void test(){
        solution.solveSudoku(nums);
        print(nums);
    }
    public void print(char[][] nums){
        for (char[] num : nums) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(num[j]);
                if (j < nums[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
