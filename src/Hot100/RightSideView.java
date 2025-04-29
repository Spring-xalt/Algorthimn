package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  Lc 199 二叉树的右视图
 */
public class RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return list;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
                // 当前层序最后一个元素
                if(i==size-1){
                    list.add(node.val);
                }
            }
        }
        return list;
    }

}
