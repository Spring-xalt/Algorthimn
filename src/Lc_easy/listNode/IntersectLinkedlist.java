package Lc_easy.listNode;

public class IntersectLinkedlist {
    public listNode getIntersectionNode(listNode headA, listNode headB) {
        listNode tempA = headA;
        listNode tempB = headB;
        listNode top;
        //  4,1,8,4,5
        //  5,6,1,8,4,5
        while(tempA!=null){
            while(tempB!=null){
                if(tempA.val==tempB.val){
                    //假设是相交起点
                    top = tempA;
                    while(tempA.next!=null&&tempB.next!=null){
                        // 当前值相等，下一个不为空
                        if(tempA.next.val==tempB.next.val){
                            //下一个也相等，前进
                            tempA=tempA.next;
                            tempB=tempB.next;
                        }
                        else{
                            //下一个不相等，将b链前进并 否认该假设起点
                            top=null;
                            tempB=tempB.next;
                            break;
                        }
                    }
                    if(tempA.next==null&&tempB.next==null){
                        //如果两节点的下一部分是两个链的末尾，则为真
                        return top;
                    }
                }
                else{
                    tempB=tempB.next;
                }
            }
            tempA=tempA.next;
            tempB=headB;
        }
        return null;
    }

}
class listNode {
    int val;
    listNode next;
    listNode(int x) {
        val = x;
        next = null;
    }
}