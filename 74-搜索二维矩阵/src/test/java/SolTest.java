import org.junit.Test;

/**
 *
 * @author wubiao21 2020年07月10日 18:45:07
 */
public class SolTest {

    private Solution2 solution=new Solution2();

    @Test
    public void test(){
        int[][] arr={{1},{3}};
        System.out.println(arr.length);
        System.out.println(solution.searchMatrix(arr, 2));
    }
}


    