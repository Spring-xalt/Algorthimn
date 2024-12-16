package Lc_mid.Hash;

import java.util.*;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 49  字母异位词分组
 */
public class Z {
    // 法一: hash暴力 未使用 都是小写字母的条件
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        List<Map<Character, Integer>> lm = new ArrayList<>();

        for (String s : strs) {
            Map<Character, Integer> m = getMap(s);
            boolean found = false;
            for (int i = 0; i < lm.size(); i++) {
                if (m.equals(lm.get(i))) {  // 比较 Map 内容
                    ans.get(i).add(s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                lm.add(m);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                ans.add(newGroup);
            }
        }
        return ans;
    }
    public Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        return map;
    }


    // 法二 根据排序法 排序后将排序后的每个str存入key 每个value存 异位词组
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map <String ,List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch);
            // 关键一步
            List <String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(s);

            map.put(key, list);

        }
        return new ArrayList<>(map.values());
    }
}
