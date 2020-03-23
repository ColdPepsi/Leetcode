/**
 * @author WuBiao
 * @date 2020/3/23 22:31
 */
public class Solution {
    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return void
     * @description 倒着来处理 不然前面的就被覆盖了
     * @author WuBiao
     * @date 2020/3/23 22:37
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexmerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {//nums1已经拷贝完了，只需要处理nums2
                nums1[indexmerge--] = nums2[index2--];
            } else if (index2 < 0) {//nums2已经拷贝完了，只需要处理nums1
                nums1[indexmerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexmerge--] = nums1[index1--];
            } else {
                nums1[indexmerge--] = nums2[index2--];
            }
        }
    }
}