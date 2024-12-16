package Lc_mid.DP;
import java.util.HashMap;
public class MaxBudgetSubString {
    public static void main(String[] args) {
        System.out.println(maximumCostSubstring("pprpf","frep",new int[]{-5,-4,-4,3}));
    }
    public static int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> m = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            m.put(chars.charAt(i),i);
        }
        int n=s.length();
        int []value=new int[n];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            value[i]=(m.containsKey(ch)?vals[m.get(ch)]:ch-96);
        }
        //动态规划法 如果小于0，则重置为当前值
        //          否则加上当前值
        int currentMax=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(currentMax<0){
                currentMax=value[i];
            }
            else{
                currentMax+=value[i];
            }
            max=Math.max(max,currentMax);
        }
        return max;
    }
    public int get(String s, String chars, int[] vals){
        var mapping = new int[26];
        for (int i=0;i<26;++i)
            mapping[i]=i+1;
        for (int i=0;i<vals.length;++i)
            mapping[chars.charAt(i)-'a']=vals[i];
        int ans=0,f=0;
        for (char c:s.toCharArray()) {
            f=Math.max(f,0)+mapping[c-'a'];
            ans=Math.max(ans, f);
        }
        return ans;
    }
}
