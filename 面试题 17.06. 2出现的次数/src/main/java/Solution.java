/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：模仿剑指offer43题
 *
 * @author wubiao21 2020年08月21日 11:12:00
 */
public class Solution {
    public int numberOf2sInRange(int n) {
        int count = 0;
        for (int k = 1; k <= n; k *= 10) {
            long abc = n % k;
            long xyzd = n / k;
            long d = xyzd % 10;
            long xyz = xyzd / 10;
            count += xyz * k;
            if (d > 2) {//d>2时候，低位abc可以取到[0...k-1]，，一共k种可能
                count += k;
            } else if (d == 2) {//d==2时候，低位的abc可以取到[0...abc]，一共abc+1种可能
                count += abc + 1;
            }//d位是0或1的时候，不用计数，因为d位不会出现2
        }
        return count;
    }
}