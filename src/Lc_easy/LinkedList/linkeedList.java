package Lc_easy.LinkedList;

// Lc 160 相交链表
public class linkeedList {
    // 暴力法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        ListNode ans;
        while(tempA!=null){
            while(tempB!=null){
                if(tempA.val==tempB.val){
                    //假设是相交起点
                    ans = tempA;
                    while(tempA.next!=null&&tempB.next!=null){
                        // 当前值相等，下一个不为空
                        if(tempA.next.val==tempB.next.val){
                            //下一个也相等，前进
                            tempA=tempA.next;
                            tempB=tempB.next;
                        }
                        else{
                            //下一个不相等，将b链前进并退出该假设起点
                            tempB=tempB.next;
                            break;
                        }
                    }
                    if(tempA.next==null&&tempB.next==null){
                        //如果相交起点均是两个链的末尾，则为真
                        return ans;
                    }
                }
                else{
                    tempB=tempB.next;
                }
            }
            tempA=tempA.next;tempB=headB;
        }
        return null;
    }
    // 双指针法
     // A B分别从ab两条链表出发 A到a末尾后从b的头继续遍历 B同理 最终二者一定会相遇在相交结点上
    public  ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while(tempA!=tempB){
            tempA=(tempA==null?headB:tempA.next);
            tempB=(tempB==null?headA:tempB.next);

            // 直接把属于自己的链表走完 只要有相交的 下一次一定会找到
        }
        return tempA;
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