package KthNode;
//给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。

import Tree.Tree;

import java.util.Stack;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class Solution{
    int index = 0;
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot != null){
            TreeNode node = KthNode(pRoot.left, k);
            if(node != null)
                return node;
            index ++;
            if(index == k)
                return pRoot;
            node = KthNode(pRoot.right, k);
            if(node != null)
                return node;
        }
        return null;
    }
}

class Solution1{
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k == 0)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode node = pRoot;
        while(node != null || !stack.isEmpty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                node = stack.pop();
                count ++;
                if(count == k)
                    return node;
                node = node.right;
            }
        }
        return null;
    }
}

public class KthNode {
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode l = new TreeNode(3);
        TreeNode r = new TreeNode(7);
        TreeNode ll = new TreeNode(2);
        TreeNode lr = new TreeNode(4);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(8);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().KthNode(root, 5).val);
        System.out.println(new Solution1().KthNode(root, 5).val);
    }
}
