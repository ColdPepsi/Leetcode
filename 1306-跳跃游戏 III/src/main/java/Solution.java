/**
 * @author WuBiao
 * @date 2020/5/15 16:47
 */
public class Solution {
    public boolean canReach(int[] arr, int start) {
        return DFS(arr, start, new boolean[arr.length]);
    }

    private boolean DFS(int[] arr, int start, boolean[] hasVisited) {
        if (arr[start] == 0) {
            return true;
        }
        hasVisited[start] = true;
        int next1 = start + arr[start];
        int next2 = start - arr[start];
        if (inArr(arr, next1) && !hasVisited[next1]) {
            if (DFS(arr, next1, hasVisited)) {
                return true;
            }
        }
        if (inArr(arr, next2) && !hasVisited[next2]) {
            return DFS(arr, next2, hasVisited);
        }
        return false;
    }

    private boolean inArr(int[] arr, int start) {
        return start >= 0 && start < arr.length;
    }
}