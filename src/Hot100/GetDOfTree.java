package Hot100;

/*
 *@auther:Jimi
 *@version:1.0
 *@description:  lc 543 获得二叉树的直径
 */
public class GetDOfTree {
    static int max=0;
    public static int diameterOfBinaryTree(TreeNode root) {
        getD(root);
        return max;
    }
    public static int getD(TreeNode root) {
        if(root==null){
            return 0;
        }
        int l=getD(root.left);
        int r=getD(root.right);
        // 在该结点记录的是以该节点为连接中轴的max
        max=Math.max(max,l+r);
        // 每次返回的是边数
        return Math.max(l,r)+1;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        System.out.println(diameterOfBinaryTree(root));
    }
}
