import org.junit.Test;

/**
 * @author WuBiao
 * @date 2020/3/15 18:45
 */
public class TestLIS {
    Solution solution=new Solution();

    @Test
    public void TestLIS111(){
        int[] nums={10,9,2,5,3,4};
        int res= solution.lengthOfLIS2(nums);
        System.out.println(res);
    }
}
