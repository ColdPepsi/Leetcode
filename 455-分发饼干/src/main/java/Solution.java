import java.util.Arrays;

/**
 * @author WuBiao
 * @date 2020/3/19 14:12
 */
public class Solution {
    /**
     * @param g
     * @param s
     * @return int
     * @description 贪心，优先满足胃口最小的孩子，给他满足他的最小的饼干
     * @author WuBiao
     * @date 2020/3/19 14:17
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null || g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);//都排序
        int gi = 0, si = 0;
        while (si < s.length && gi < g.length) {
            if (g[gi] <= s[si]) {//优先满足胃口最小的孩子
                gi++;
            }
            si++;
        }
        return gi;//返回结果
    }
}