import org.junit.Test;

/**
 * @author WuBiao
 * @date 2020/3/10 12:39
 */
public class SortTest {

    @Test
    public void quickTest(){
        int[] nums={1,4,2,7,2};
        Sort.quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    @Test
    public void mergeSortTest(){
        int[] nums={1,8,9,6,3};
        Sort.mergeSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
