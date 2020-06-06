/**
 * @author WuBiao
 * @date 2020/6/6 15:46
 */
public class Test {
    Solution solution = new Solution();

    @org.junit.Test
    public void test() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(arr));
    }
}
