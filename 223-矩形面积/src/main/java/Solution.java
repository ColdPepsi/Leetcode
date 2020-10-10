/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：主要是区分各种重叠情况
 *
 * @author wubiao21 2020年10月10日 10:31:41
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        if (G <= A || C <= E || H <= B || D <= F) {//两个矩形不重叠
            return (G - E) * (H - F) + (C - A) * (D - B);
        }
        if (A >= E && B >= F && C <= G && D <= H) {//EFGH包含ABCD
            return (G - E) * (H - F);
        }
        if (E >= A && F >= B && G <= C && H <= D) {//ABCD包含EFGH
            return (C - A) * (D - B);
        }
        return (G - E) * (H - F) + (C - A) * (D - B) -
                (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));//计算面积,两面积相加减去重叠面积
    }
}