package WeekCompetition;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//周赛 416
// 统计重新排列后另一个字符串的子字符串数目I
public class RePaiXu {
    public long validSubstringCount(String word1, String word2) {
        HashMap<Character,Integer> x = new HashMap<>();
        for(int i=0;i<word2.length();i++){
            if(!x.containsKey(word2.charAt(i))){
                x.put(word2.charAt(i),1);
            }
            else{
                x.put(word2.charAt(i),x.get(word2.charAt(i))+1);
            }
        }
        for(int i=0;i<word1.length();i++){
            if(x.containsKey(word1.charAt(i))){
                x.put(word1.charAt(i),x.get(word1.charAt(i))-1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> entries = x.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<Character, Integer> entry = entries.next();
            if(entry.getValue()>0)return 0;
        }
        return 0;
    }
}
