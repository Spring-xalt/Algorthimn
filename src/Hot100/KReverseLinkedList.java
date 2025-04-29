package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 25 k个一组翻转链表
 */
public class KReverseLinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);

        // 递归进入下一轮k个元素
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        // lc 206 翻转链表的迭代法
        // 预定义两个指针用于迭代 保存当前结点与前后节点之间的信息
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            // pre next分别指代前后指针 next先指向后面保存后结点信息 接着断掉后结点
                                            // 再把头结点放给pre  head再指向后面 完成两个结点翻转 并前进 pre保存头结点
            next = head.next;
            head.next = pre;
            pre = head;

            head = next;
        }
        return pre;

    }
}
