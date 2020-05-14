/**
 * @author WuBiao
 * @date 2020/5/14 21:50
 */
public class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree = new int[N + 1];//记录入度
        int[] outDefree = new int[N + 1];//记录出度
        for (int[] edge : trust) {
            inDegree[edge[1]]++;
            outDefree[edge[0]]++;
        }
        for (int i = 1; i < N + 1; i++) {
            if (outDefree[i] == 0 && inDegree[i] == N - 1) {
                return i;//找到出度为0，入度为N-1的点
            }
        }
        return -1;
    }
}