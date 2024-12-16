package Lc_mid.DataStcuture;
// Lc 2390 去除星号的字符串
public class RemoveStarString {
    public static void main(String[] args) {
        System.out.println(removeStars("erase*****"));
    }
    public static String removeStars(String s) {
        int count=0;
        StringBuffer str=new StringBuffer(s);
        for(int j=str.length()-1;j>=0;j--){
            if(s.charAt(j)=='*'){
                count++;
                str.deleteCharAt(j);
            }
            else if(count>0){
                count--;
                str.deleteCharAt(j);
            }
        }
        return str.toString();
    }
}
