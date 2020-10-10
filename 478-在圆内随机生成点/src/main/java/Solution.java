/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

/**
 * 类Solution.java的实现描述：极坐标 x=x_center+ρ∗cos(θ),y=y_center+ρ∗sin(θ)
 * 算法思想：https://leetcode-cn.com/problems/generate-random-point-in-a-circle/solution/ji-zuo-biao-by-powcai/
 *
 * @author wubiao21 2020年10月10日 11:32:36
 */
public class Solution {

    private final double radius;
    private final double x;
    private final double y;

    public Solution(double _radius, double x_center, double y_center) {
        radius = _radius;
        x = x_center;
        y = y_center;
    }

    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());//ρ
        double theta = Math.random() * 2 * Math.PI;//θ
        return new double[]{x + d * Math.cos(theta), y + d * Math.sin(theta)};
    }
}