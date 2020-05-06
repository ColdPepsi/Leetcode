import java.util.ArrayList;
import java.util.List;

/**
 * @author WuBiao
 * @date 2020/4/28 20:34
 */
public class Solution {
    public int[] beautifulArray(int N) {
        List<Integer> prefix = new ArrayList<Integer>(N);
        backTracking(prefix, N, new boolean[N + 1]);
        int[] res = new int[N];
        int index = 0;
        for (Integer integer : prefix) {
            res[index++] = integer;
        }
        return res;
    }

    private boolean backTracking(List<Integer> prefix, int n, boolean[] hasVisited) {
        if (prefix.size() == n) {
            //判断是否是结果,时间复杂度过高
            for (int i = 0; i < n - 2; i++) {
                for (int k = i + 1; k < n - 1; k++) {
                    for (int j = k + 1; j < n; j++) {
                        if (prefix.get(k) * 2 == prefix.get(i) + prefix.get(j)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
        for (int i = 1; i <= n; i++) {
            if (!hasVisited[i]) {
                hasVisited[i] = true;
                prefix.add(i);
                if (backTracking(prefix, n, hasVisited)) {
                    return true;//找到一个结果就返回
                }
                prefix.remove(prefix.size() - 1);//恢复现场
                hasVisited[i] = false;
            }
        }
        return false;
    }
}