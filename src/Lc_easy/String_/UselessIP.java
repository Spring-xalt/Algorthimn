package Lc_easy.String_;
//Lc 1108 IP地址无效化
public class UselessIP {
    public String defangIPaddr(String address) {
        char[]s=address.toCharArray();
        StringBuffer str = new StringBuffer();
        for(int i=0;i<s.length;i++){
            if(s[i]!='.')str.append(s[i]);
            else str.append("[.]");
        }
        return str.toString();
    }
}
