/**
 * @author WuBiao
 * @date 2020/3/11 22:21
 */
public class Solution {
    /**
     * @param arr
     * @return int
     * @description 因为下标 0 ~ n-1中存放[0,n-1]中的数，且不重复，要想分组排序后有序,
     * 遍历到索引j处时，下标0 ~ j中的最大元素应该是j，则能分块。
     * @author WuBiao
     * @date 2020/3/11 22:22
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) {
                res++;
            }
        }
        return res;
    }
}