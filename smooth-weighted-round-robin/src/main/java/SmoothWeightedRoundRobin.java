/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 类SmoothWeightedRoundRobin.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月26日 09:38:35
 */
public class SmoothWeightedRoundRobin {

    /**
     * @param serverList the serverList to set
     */
    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }

    private List<Server> serverList;


    public Server getServer() {
        Server select = null;//保存被选中的服务器
        int maxCurrentWeight = Integer.MIN_VALUE;//保存最大的当前权重
        int total = 0;//计算所有的effectiveWeight总和
        for (Server server : serverList) {//遍历所有的服务器
            int temp = server.getCurrentWeight() + server.getEffectiveWeight();
            server.setCurrentWeight(temp);//每个服务器的currentWeight都加上effectiveWeight
            total += server.getEffectiveWeight();//total计算总和
            if (temp > maxCurrentWeight) {//选出最大的
                select = server;
                maxCurrentWeight = temp;
            }
        }
        select.select(total);
        return select;
    }
}

@Getter
@Setter
class Server {
    private String url;//保存服务器地址
    private int weight;//保存权重，也就是刚开始设定的值
    private int effectiveWeight;//保存有效权重，范围[0,weight]，可以根据服务器响应时间等动态调整
    private int currentWeight;//当前的权重

    public void select(int total) {
        /*如果当前的服务器被选中，当前权重减去total。
        会使当前权重衰减的厉害，所以下次可能就不会选中本服务器了，
        但是如果weight设置的大，currentWeight会很快上升，
        所以权重大的服务器，短暂休息之后又会被选中
         */
        currentWeight -= total;
    }

    public Server(String url, int weight, int effectiveWeight, int currentWeight) {
        this.url = url;
        this.weight = weight;
        this.effectiveWeight = effectiveWeight;
        this.currentWeight = currentWeight;
    }
}
    