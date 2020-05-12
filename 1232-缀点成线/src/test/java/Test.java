/**
 * @author WuBiao
 * @date 2020/5/9 10:25
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void test(){
        int[][] cords={{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(solution.checkStraightLine(cords));
    }
}
