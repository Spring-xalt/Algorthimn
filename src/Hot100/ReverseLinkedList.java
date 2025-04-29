package Hot100;

import java.util.Stack;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        //  O(n) 空间
        Stack<ListNode> s = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            s.push(temp);
            temp=temp.next;
        }
        if(s.isEmpty()) {
            return null;
        }
        ListNode newHead = s.pop();
        ListNode t=newHead;
        while(!s.isEmpty()){
            t.next = s.pop();
            t=t.next;
        }
        t.next = null; //链表结尾 null
        return newHead;
    }
    public ListNode reverseList2(ListNode head) {
        // O(1) 空间
        ListNode cur = head, pre = null;
        while(cur != null) {
            ListNode tmp = cur.next; // 暂存后继节点 cur.next
            cur.next = pre;          // 修改 next 引用指向
            pre = cur;               // pre 暂存 cur
            cur = tmp;               // cur 访问下一节点
        }
        return pre;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }
}
