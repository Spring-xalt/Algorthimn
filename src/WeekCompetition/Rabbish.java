package WeekCompetition;

import java.util.HashMap;

// 周赛416
// 举报垃圾信息 t1
public class Rabbish {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        int n=bannedWords.length;
        HashMap<String, Integer> m = new HashMap<>();
        for(int i=0;i<n;i++){
            m.put(bannedWords[i],1);
        }
        int count=0;
        for(int i=0;i<message.length;i++){
            if(m.containsKey(message[i]))count++;
        }
        return count >= 2;
    }
}
