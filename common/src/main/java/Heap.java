import lombok.Getter;

/**
 * @author WuBiao
 * @date 2020/3/10 13:54
 */
@Getter
public class Heap {
    private int[] nums;
    private int heapSize;

    Heap(int[] datas) {
        nums = datas;
        heapSize = datas.length-1;
    }

    public int indexOfParent(int i) {
        return i / 2;
    }

    public int indexOfLeftChild(int i) {
        return i * 2;
    }

    public int indexOfRightChild(int i) {
        return i * 2 + 1;
    }

    /**
     * @param root
     * @return void
     * @description 整堆，把root为根的数组，整成堆
     * @author WuBiao
     * @date 2020/3/10 14:21
     */
    public void maxHeapify(int root) {
        int left = root * 2;//左右孩子下标
        int right = left + 1;
        int largest = root;
        if (left <= heapSize && nums[root] < nums[left]) {
            largest = left;
        }
        if (right <= heapSize && nums[largest] < nums[right]) {
            largest = right;
        }
        if (largest != root) {
            int temp = nums[root];
            nums[root] = nums[largest];
            nums[largest] = temp;
            maxHeapify(largest);
        }
    }

    /**
     * @description 建立一个大顶堆
     * @author WuBiao
     * @return void
     * @date 2020/3/10 14:28
    */
    public void buildMaxHeap(){
        //对除叶子结点以外的结点调用maxHeapify函数
        for (int i = (nums.length-1)/2; i > 0; i--) {
            maxHeapify(i);
        }
    }

    /**
     * @description 堆排序
     * @author WuBiao
     * @return void
     * @date 2020/3/10 14:40
    */
    public void heapSort(){
        buildMaxHeap();
        for (int i=nums.length-1;i>1;i--){
            int temp=nums[1];
            nums[1]=nums[i];
            nums[i]=temp;
            heapSize--;
            maxHeapify(1);
        }
    }
}
