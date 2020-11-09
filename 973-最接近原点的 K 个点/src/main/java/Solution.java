/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：随机选择算法，这样时间复杂度是O(n)
 *
 * @author wubiao21 2020年11月09日 13:59:52
 */
public class Solution {
    public int[][] kClosest(int[][] points, int K) {
        node[] nodes = new node[points.length];
        for (int i = 0; i < nodes.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            nodes[i] = new node(x, y, x * x + y * y);
        }
        getK(nodes, 0, nodes.length - 1, K);
        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i][0] = nodes[i].x;
            ret[i][1] = nodes[i].y;
        }
        return ret;
    }

    private void getK(node[] nodes, int left, int right, int k) {
        if (left == right) {
            return;
        }
        int position = partition(nodes, left, right);
        int m = position - left + 1;
        if (k > m) {
            getK(nodes, position + 1, right, k - m);
        } else if (k < m) {
            getK(nodes, left, position - 1, k);
        }
    }

    private int partition(node[] nodes, int left, int right) {
        node temp = nodes[left];
        while (left < right) {
            while (left < right && nodes[right].distant > temp.distant) {
                right--;
            }
            nodes[left] = nodes[right];
            while (left < right && nodes[left].distant <= temp.distant) {
                left++;
            }
            nodes[right] = nodes[left];
        }
        nodes[left] = temp;
        return left;
    }
}

class node {
    int x;
    int y;
    int distant;

    public node(int x, int y, int distant) {
        this.x = x;
        this.y = y;
        this.distant = distant;
    }
}