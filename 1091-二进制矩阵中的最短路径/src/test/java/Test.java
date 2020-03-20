/**
 * @author WuBiao
 * @date 2020/3/20 23:37
 */
public class Test {
    Solution solution=new Solution();

    @org.junit.Test
    public void testGrid(){
        //[[0,0,0],[1,0,0],[1,1,0]]
        int[][] grid={{0,0,0},{1,0,0},{1,1,0}};
        solution.shortestPathBinaryMatrix(grid);
    }
    
}
