package Lc_mid.DataStcuture;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  二叉树层序遍历 Lc 102
public class Sequence {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)return list;
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                // 妙处在于此处处理上一层的逻辑 并加入下一层的
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            list.add(temp);
        }
        return list;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}