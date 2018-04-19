package TreeDepth;
//输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。

import jdk.nashorn.api.tree.Tree;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//递归
class Solution{
    private boolean isBalanced = true;

    public boolean IsBalanced(TreeNode root){
        TreeDepth(root);
        return isBalanced;
    }

    private int TreeDepth(TreeNode root){
        if(root == null)
            return 0;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        if(Math.abs(left - right) > 1)
            isBalanced = false;

        return(left > right) ? (left + 1) : (right + 1);
    }
}

public class TreeDepth {
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode lrl = new TreeNode(7);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        lr.left = lrl;
        r.right = rr;

        System.out.println(new Solution().IsBalanced(root));
    }
}
