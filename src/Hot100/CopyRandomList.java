package Hot100;

import java.util.HashMap;
import java.util.Map;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:   Lc 138 复制随机链表
 */
public class CopyRandomList {
    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node headNew = new Node(head.val);
            map.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);
    }

}
