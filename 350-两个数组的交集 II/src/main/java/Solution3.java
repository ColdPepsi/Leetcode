import java.util.Arrays;

/**
 * 类Solution3.java的实现描述：排序做法
 *
 * @author wubiao21 2020年07月13日 09:43:29
 */
public class Solution3 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] tempRet = new int[nums1.length];
        int index = 0;
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                tempRet[index++] = nums1[i++];
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return Arrays.copyOfRange(tempRet, 0, index);
    }
}