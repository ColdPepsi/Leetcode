import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WuBiao
 * @date 2020/3/19 14:33
 */
public class Solution {
    /**
     * @param intervals
     * @return int
     * @description 贪心，要想无重叠区间尽可能多，应该选区间右端点尽可能小的
     * @author WuBiao
     * @date 2020/3/19 14:43
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });//按照每个区间的右端点从小到大排序
        int pre = Integer.MIN_VALUE;
        int curr = 0;//保存当前无重叠区间的长度
        for (int[] interval : intervals) {
            if (interval[0] >= pre) {
                pre = interval[1];
                curr++;
            }
        }
        return intervals.length - curr;
    }
}