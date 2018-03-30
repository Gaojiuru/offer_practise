package CreateBinaryTree;
//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
// 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
// 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x){
        val = x;
    }
}

class Solution{
    public TreeNode reConstructBinaryTree(int[] pre, int[] in){
        TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPreorder, int endPreorder, int[] in, int startInorder, int endInorder){
        if(startInorder > endInorder || startPreorder > endPreorder)
            return null;
        TreeNode root = new TreeNode(pre[startPreorder]);
        for(int i = startInorder; i <= endInorder; i ++){
            if(in[i] == pre[startPreorder]){
                root.left = reConstructBinaryTree(pre, startPreorder + 1, startPreorder + i -startInorder, in, startInorder, i - 1);
                root.right = reConstructBinaryTree(pre, startPreorder + i - startInorder + 1, endPreorder, in, i + 1, endInorder);
                break;
            }
        }
        return root;
    }
}

public class CreateBinaryTree {
    public static void main(String[] args){
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        Solution s = new Solution();
        s.reConstructBinaryTree(preorder, inorder);
    }
}
