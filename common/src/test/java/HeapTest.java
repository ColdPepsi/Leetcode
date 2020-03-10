import org.junit.Test;

/**
 * @author WuBiao
 * @date 2020/3/10 14:44
 */
public class HeapTest {

    @Test
    public void HeapSortTest(){
        int[] nums={-1,3,5,7,4};
        Heap heap=new Heap(nums);
        heap.heapSort();
        nums=heap.getNums();
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
