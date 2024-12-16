package Lc_easy.listNode;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc  环形链表2
 */
public class Huanlist2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)return null;
        ListNode slow =head;
        ListNode fast= head;
        while(fast!=null&&fast.next != null){
            slow = slow.next;
            fast=fast.next.next;
            if(slow == fast){
                /*
                 从第一种方法我们知道  二者一定会在环内相遇 但是不一定会在入环口? 如何找到环口?
                    我们假定从head到入环口的距离为 a ,slow 走到相遇点一共走了 b  根据快慢指针,fast一定走了 2b
                                            我们再假定 快指针比慢的多走了k圈 每圈为x
                                            易得 2b-b= kc (即 b=kc )
                                            我们易得 slow指针从入环口到相遇点 走了 b-a = kc-a
                                            我们注意到 如果再走a步呢 ??? 刚好和head到入环口的距离相同
                                            则可以让head和相遇点指针一起走 一定会同时相遇
                 */
                while(slow!=head){
                    slow = slow.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }
}
