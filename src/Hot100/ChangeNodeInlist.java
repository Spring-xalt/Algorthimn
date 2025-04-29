package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc
 */
public class ChangeNodeInlist {
    public ListNode swapPairs(ListNode head) {
        // 我们思考 如果像 单独仅仅插入一两个节点那样子 设置node 改变前后指针 太过复杂 还要处理 每两个指针之间的逻辑
        // 对于节点数至少为2 的结点 我们设置newHead为 第二个元素(新head) 旧的head为新的第二个结点  、
        // 接着通过递归一直处理 每两个结点之间的元组逻辑
        if(head == null || head.next == null){
            return head;
        }
        // 取出第二个元素 (新head)
        ListNode newHead=head.next;
        // 现根据第二个元素和后面元素的关系 递归后面
        head.next=swapPairs(newHead.next);
        // 更改最初的head为newHead
        newHead.next=head;
        return newHead;
    }
}
