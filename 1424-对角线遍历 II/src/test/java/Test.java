import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/5/26 18:45
 */
public class Test {
    Solution2 solution=new Solution2();

    @org.junit.Test
    public void test(){
        List<List<Integer>> nums=new ArrayList<>();
        nums.add(Arrays.asList(1,2,3));
        nums.add(Arrays.asList(4,5,6));
        nums.add(Arrays.asList(7,8,9));
        solution.findDiagonalOrder(nums);
    }
}
