/*
 * Copyright 2013-2018 duolabao.com All right reserved. This software is the confidential and proprietary information of
 * duolabao.com ("Confidential Information"). You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the license agreement you entered into with duolabao.com.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author wubiao21 2020年07月31日 09:40:24
 */
public class Solution {
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>(names.length);
        for (String name : names) {
            String[] nameandFrequency = getNameandFrequency(name);
            map.put(nameandFrequency[0], Integer.parseInt(nameandFrequency[1]));
        }
        for (String name : synonyms) {
            String[] SynonyNames = getNames(name);
            if (SynonyNames[0].compareTo(SynonyNames[1]) <= 0) {
                map.put(SynonyNames[0], map.getOrDefault(SynonyNames[0], 0) + map.getOrDefault(SynonyNames[1], 0));
                map.remove(SynonyNames[1]);
            } else {
                map.put(SynonyNames[1], map.getOrDefault(SynonyNames[0], 0) + map.getOrDefault(SynonyNames[1], 0));
                map.remove(SynonyNames[0]);
            }
        }
        String[] ret = new String[map.size()];
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ret[index++] = entry.getKey() + '(' + entry.getValue() + ')';
        }
        return ret;
    }

    private String[] getNameandFrequency(String str) {
        int leftBracketPos = str.length() - 1;
        while (str.charAt(leftBracketPos) != '(') {
            leftBracketPos--;
        }
        return new String[]{str.substring(0, leftBracketPos), str.substring(leftBracketPos + 1, str.length() - 1)};
    }

    private String[] getNames(String str) {
        int pos = str.indexOf(',');
        return new String[]{str.substring(1, pos), str.substring(pos + 1, str.length() - 1)};
    }
}

    