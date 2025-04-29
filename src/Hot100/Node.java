package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:
 */
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
