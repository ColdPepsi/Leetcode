/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：本题的余数只能是0或者1，所以当余数出现负数的时候，我们要把余数修正为1
 *
 * @author wubiao21 2020年08月13日 18:43:18
 */
public class Solution {
    public String baseNeg2(int N) {
        StringBuilder res = new StringBuilder(40);
        while (N != 0) {
            int mod = N % (-2);
            N /= -2;
            if (mod == -1) {
                res.append(1);
                N++;
            } else {
                res.append(mod);
            }
        }
        return res.length() == 0 ? "0" : res.reverse().toString();
    }
}
/*
其实本题想让我们得到的解题结果只包含0或者1，但是我们数学运算出来的结果却是0或-1；所以我们对结果进行修正
        比如数学运算 (-3)/(-2)等于1余-1，
        但是题目想让我们得到的结果是(-3)/(-2)等于2余1;我们看到把余数修正为1，需要我们把商加1;
        现在我们把描述一般化：
        把算式写成a-(-2)*b=c，其实a是被除数，b是商，c是余数
        等式两边同时减去(-2),得到a-(-2)b-(-2)=c-(-2)
        进行化简：a-(-2)(b+1)=c+2;
        此时 a是被除数，b+1是商，c+2是余数。
        所以当余数是-1时候，如果我们想把余数变为1，也就是变成了c+2；我们正确的商应该是b+1；原来的商加1
*/
