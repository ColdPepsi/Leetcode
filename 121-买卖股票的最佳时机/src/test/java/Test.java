/**
 * @author WuBiao
 * @date 2020/3/19 20:08
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void testMax(){
        int[] arr=new int[]{7,1,5,3,6,4};
        System.out.println(solution.maxProfit3(arr));
    }
}
