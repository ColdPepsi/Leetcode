/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 类Solution.java的实现描述：克隆图
 *
 * @author wubiao21 2020年07月16日 11:03:18
 */
public class Solution {

    private Map<Node, Node> vistied = new HashMap<>();//键是原图中的结点，值是新克隆的结点

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node newNode = vistied.getOrDefault(node, null);
        if (newNode == null) {
            newNode = new Node(node.val);//没有克隆过，新克隆一个结点
            vistied.put(node, newNode);//放入map
            for (Node neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));//递归克隆每个邻接点
            }
        }
        return newNode;
    }

    /*
    dfs代码，相似度很高
    private void dfs(Node node, boolean[] hasVisited) {
        if (hasVisited[node.val]) {
            return;
        }
        hasVisited[node.val] = true;
        for (Node neighbor : node.neighbors) {
            dfs(neighbor, hasVisited);
        }
    }*/
}