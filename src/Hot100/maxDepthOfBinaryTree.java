package Hot100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:
 */
public class maxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        // 递归写法
        if(root == null){
            return 0;
        }
        else{
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return Math.max(left,right)+1;
        }
    }

    public int maxDepth2(TreeNode root) {
        //非递归写法 dfs  用 节点栈 和 深度栈dfs所有结点 得到maxDepth
        if(root==null){
            return 0;
        }
        //
        Stack<TreeNode> s=new Stack<>();
        Stack<Integer> height=new Stack<>();
        int max=0;
        height.push(1);
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node=s.pop();
            int curDepth=height.pop();
            max=Math.max(max,curDepth);

            if(node.left!=null){
                s.push(node.left);
                height.push(curDepth+1);
            }
            if(root.right!=null){
                s.push(root.right);
                height.push(curDepth+1);
            }
        }
        return max;
    }
    public int maxDepth3(TreeNode root) {
        //bfs实现
        if(root==null){
            return 0;
        }
        Queue<TreeNode> q=new LinkedList();
        q.offer(root);
        int depth=0;
        while(!q.isEmpty()){
            int size=q.size();
            depth++;
            TreeNode node=q.poll();
            for(int i=0;i<size;i++){
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return depth;
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