package leetcode;

import java.util.*;

/**
 * 同形词，种类数量一致
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class Problem36_Code49 {
    /**
     * 利用hashmap
     * <p>
     * k：字符串
     * v:list存放同形词
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            } else {
                map.get(key).add(str);
            }

        }


        List<List<String>> res = new ArrayList<>();
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
