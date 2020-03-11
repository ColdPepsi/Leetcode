/**
 * @author WuBiao
 * @date 2020/3/11 18:52
 */
public class Solution {
    /**
     * @param n
     * @param k
     * @return int[]
     * @description 重复翻滚
     * @author WuBiao
     * @date 2020/3/11 19:27
     */
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int left = 1;
        int right = n;
        //前k个数从两端间隔取
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                res[i] = left;
                left++;
            } else {
                res[i] = right;
                right--;
            }
        }
        //剩下的数按照升序或者降序排列
        //k是奇数的时候，升序
        if (k % 2 == 1) {
            for (int i = k; i < n; i++) {
                res[i] = left++;
            }
        } else {
            //k是偶数降序
            for (int i = k; i < n; i++) {
                res[i] = right--;
            }
        }
        return res;
    }
}
//可以发现每次反转会多出一种间隔，k 种间隔就反转 k 即可；
//进一步观察发现;如果需要 k 个不同的间隔；
//1.前 k 个数需要间隔从两端取；
//2.剩下的数字则按照降序或者升序排列
//
//作者：TheWayshower
//链接：https://leetcode-cn.com/problems/beautiful-arrangement-ii/solution/java-bu-duan-fan-zhuan-zai-tong-guo-guan-cha-zhi-j/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。