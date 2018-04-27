package PrintTreeZ;
//请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
// 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)
            return res;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        int Level = 1;
        stack1.push(pRoot);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (Level % 2 == 1) {
                int size = stack1.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack1.pop();
                    temp.add(node.val);
                    if (node.left != null)
                        stack2.push(node.left);
                    if (node.right != null)
                        stack2.push(node.right);
                }
                Level ++;
            }
            else {
                int size = stack2.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = stack2.pop();
                    temp.add(node.val);
                    if (node.right != null)
                        stack1.push(node.right);
                    if (node.left != null)
                        stack1.push(node.left);
                }
                Level ++;
            }
            res.add(temp);
        }
        return res;
    }
}

public class PrintTreeZ {
    public static void main(String[] args){
        TreeNode root = new TreeNode(8);
        TreeNode l = new TreeNode(6);
        TreeNode r = new TreeNode(10);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.left = rl;
        r.right = rr;
        System.out.println(new Solution().Print(root));
    }
}
