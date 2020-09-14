/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.Scanner;

/**
 * 类Main.java的实现描述：第一行给一个数N，在[-n,-1],[1,n]每个整数点处都有一个怪兽，接下来输入2行，第一行是打每个怪兽需要消耗的能量，第二行是打每个怪兽收获的能量，当勇士能量为0的时候就死亡。
 * 从坐标0处开始打怪兽，每次可以打左右两边的怪兽，不能跳过怪兽，求消灭所有怪兽需要的最小能量
 *
 * @author wubiao21 2020年09月07日 16:06:05
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] s = sc.nextLine().split(" ");
        String[] s1 = sc.nextLine().split(" ");
        int[] consume1 = new int[n];//[-n,-1]需要消耗的值
        int[] get1 = new int[n];//[-n,-1]收获的值
        for (int i = 0; i < n; i++) {//[-n,-1]的值是逆过来的，翻转
            consume1[i] = Integer.parseInt(s[n - 1 - i]);
            get1[i] = Integer.parseInt(s1[n - 1 - i]);
        }
        int[] consume2 = new int[n];//[1,n]需要消耗的值
        int[] get2 = new int[n];//[1,n]收获的值
        for (int i = 0; i < n; i++) {
            consume2[i] = Integer.parseInt(s[i + n]);
            get2[i] = Integer.parseInt(s1[i + n]);
        }
        int[][] memo = new int[n + 1][n + 1];//用于记忆化
        memo[n][n] = 1;
        System.out.println(dp(0, 0, memo, consume1, consume2, get1, get2, n));
    }

    /**
     * dp(i,j)表示从负区间i,正区间j打到dp(n,n)所需要的最小的能量
     *
     * @param i
     * @param j
     * @param memo
     * @param consume1
     * @param consume2
     * @param get1
     * @param get2
     * @param n
     * @return
     */
    private static int dp(int i, int j, int[][] memo, int[] consume1, int[] consume2, int[] get1, int[] get2, int n) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int min;//最小需要的能量
        int min2;//保存直接打怪兽需要消耗的最少能量，因为得先打怪兽才能获得能量，所以 最后的结果不会小于min2
        if (i == n) {//负区间到终点，递归正区间
            min = Math.max(dp(i, j + 1, memo, consume1, consume2, get1, get2, n) + consume2[j] - get2[j], 1);
            min2 = consume2[j] + 1;
        } else if (j == n) {//正区间到终点，递归负区间
            min = Math.max(dp(i + 1, j, memo, consume1, consume2, get1, get2, n) + consume1[i] - get1[i], 1);
            min2 = consume1[i] + 1;
        } else {//选两条路的最小值
            min = Math.min(dp(i, j + 1, memo, consume1, consume2, get1, get2, n) + consume2[j] - get2[j],
                    dp(i + 1, j, memo, consume1, consume2, get1, get2, n) + consume1[i] - get1[i]);
            min2 = Math.min(consume2[j], consume1[i]) + 1;
        }
        if (min2 > min) {
            min = min2;
        }
        memo[i][j] = min;
        return min;
    }
}
/*
测试数据：
2
6 5 8 9
1 20 1 0
正确答案：7
*/
