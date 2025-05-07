package Hot100;

import java.util.ArrayList;
import java.util.List;

/*
 *@auther:Jimi
 *@version:1.0
 *@description: Lc 114 二叉树转为链表
 */
public class TreeToLinkedList {

    public void flatten(TreeNode root) {
        List<TreeNode> l=new ArrayList<>();
        if(root==null){
            return;
        }
        goFirst(root,l);
        TreeNode cur=root;
        for(int i=1;i<l.size();i++){
            cur.left=null;
            cur.right=l.get(i);
            cur=cur.right;
        }

    }
    public void goFirst(TreeNode root,List<TreeNode> l) {
        if(root == null){
            return;
        }
        l.add(root);
        goFirst(root.left,l);
        goFirst(root.right,l);
    }
}
