package ChuanZhiCup;
import java.util.Scanner;

public class _2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        // yab
        char []ch=str.toCharArray();
        // aby
        int n=ch.length;    //3
        int []arr=new int[26];
        for(int i=0;i<26;i++){
            arr[ch[i]-'a']++;
        }
        // 构建字母表做
        int ans=Integer.MAX_VALUE,count;
        for(int i=0;i<26;i++){
            count=0;
            for(int j=0;j<26;j++){
                int dis=Math.min(Math.abs(j-i),26-Math.abs(j-i));
                count+=dis*arr[j];
            }
            ans=Math.min(ans,count);
        }
        System.out.println(ans);
    }
}
