package Lc_easy.Binary;

// Lc 226 翻转二叉树
public class ReverseBinary {
    // 先行考虑 如果细致入手  可能需要每一个叉一个中间变量 过于臃肿
        // 二叉树 多用递归思考 先行将左右子树的结果统计下来 最终翻转即可
        // 将树一直往下延伸 至 末端 我们考虑 为空即返回而已
    public TreeNode invertTree(TreeNode root) {
            if(root==null)return root;
            // 获取左右子树
            TreeNode left=invertTree(root.left);
            TreeNode right=invertTree(root.right);
            root.left=right;
            root.right=left;
            return root;
    }
}
