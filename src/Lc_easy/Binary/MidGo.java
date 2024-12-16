package Lc_easy.Binary;

import java.util.ArrayList;
import java.util.List;

public class MidGo {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode root,List<Integer> list){
        // 退出时机
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
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