package Hot100;

import java.util.Stack;

// Lc 234 回文链表
public class linkedList {
    public static boolean isPalindrome(listNode head) {
        Stack<Integer> s = new Stack<Integer>();
        listNode temp = head,temp1 = new listNode();temp1.next = head;
        int l=0;
        while (temp != null) {
            l++;
            temp = temp.next;
        }
        int i=0;
        while(i<l/2){
            temp1 = temp1.next;
            s.push(temp1.val);
            i++;
        }
        if(l%2==0){
            while(!s.isEmpty()){
                temp1 = temp1.next;
                if(s.peek()!=temp1.val){
                    return false;
                }
                s.pop();
            }
        }
        else{
            temp1=temp1.next;
            while(!s.isEmpty()){
                temp1 = temp1.next;
                if(s.peek()!=temp1.val){
                    return false;
                }
                s.pop();
            }
        }
        return true;
    }
}
class listNode {
    int val;
    listNode next;
    listNode() {}
    listNode(int val) { this.val = val; }
    listNode(int val, listNode next) { this.val = val; this.next = next; }
}