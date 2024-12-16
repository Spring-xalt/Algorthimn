package MarsCode;

public class Main {
    public static String solution(String s) {
        // write code here
        int l=s.length();
        boolean isZero=(s.charAt(0)=='0')?true:false;
        StringBuffer str = new StringBuffer();
        int count=0;            //记录有效数字的个数
        int i=0;
        while(i<l&&s.charAt(i)!='.'){
            if(!isZero){
                count++;
                str.append(s.charAt(i));
            }
            else{
                if(s.charAt(i)!='0'){
                    isZero=false;
                    str.append(s.charAt(i));
                    count++;
                }
            }
            i++;
        }
        int index=count%3;
        if(index==0){index=3;}
        int num=count/3;        //要加入的,数目
        if(index==3)num--;
        int hasD=0;
        while(num>0){
            str.insert(index,',');
            hasD++;         // 已经存在的 , 个数
            index+=4;
            num--;
        }
        while(i<l){
            str.append(s.charAt(i));
            i++;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("02300545202").equals("2,300,545,202"));
    }
}
