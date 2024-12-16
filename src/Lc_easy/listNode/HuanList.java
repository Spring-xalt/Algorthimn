package Lc_easy.listNode;



/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 141环形链表
 */
public class HuanList {
    public boolean hasCycle(ListNode head) {
        // 快慢指针 从头开始设置每个结点为慢指针 接着快指针一直往后遍历 时间复杂度太高 不是真正的快慢指针 没有体现快慢
        if(head == null || head.next == null)return false;
        ListNode slow =head;
        while(slow.next != null) {
            ListNode fast=slow.next;
            while(fast!=slow&&fast!=null) {
                fast=fast.next;
                if(fast==slow)return true;
            }
            slow=slow.next;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head) {
        if(head == null || head.next == null)return false;
        // 快指针慢指针一定会相遇 用相对速度考虑 只要有环
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow&&fast!=null)return true;
        }
        return false;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }