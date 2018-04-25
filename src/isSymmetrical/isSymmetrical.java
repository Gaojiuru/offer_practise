package isSymmetrical;
//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的.

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

}

class Solution{
    boolean isSymmetrical(TreeNode pRoot){
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2){
        if(pRoot1 == null && pRoot2 == null)
            return true;
        if(pRoot1 == null || pRoot2 == null)
            return false;
        if(pRoot1.val != pRoot2.val)
            return false;
        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}

public class isSymmetrical {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(6);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(7);
        TreeNode rr = new TreeNode(6);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().isSymmetrical(root));
    }
}
