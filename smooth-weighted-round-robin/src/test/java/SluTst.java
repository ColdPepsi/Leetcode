/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类SluTst.java的实现描述：TODO 类实现描述
 *
 * @author wubiao21 2020年08月26日 10:17:42
 */
public class SluTst {

    private final SmoothWeightedRoundRobin smoothWeightedRoundRobin = new SmoothWeightedRoundRobin();

    @Test
    public void test() {
        Server serverA = new Server("a", 4, 4, 0);
        Server serverB = new Server("b", 2, 2, 0);
        Server serverC = new Server("c", 1, 1, 0);
        List<Server> serverList=new ArrayList<>(Arrays.asList(serverA,serverB,serverC));
        smoothWeightedRoundRobin.setServerList(serverList);

        List<Server> res=new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            res.add(smoothWeightedRoundRobin.getServer());
        }
        for (Server server : res) {
            System.out.println(server.getUrl());
        }
    }
}

    