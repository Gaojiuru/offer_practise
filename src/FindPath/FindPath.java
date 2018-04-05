package FindPath;
//输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
// 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

import java.util.ArrayList;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

class Solution{
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if(root == null)
            return res;
        target -= root.val;
        path.add(root.val);
        if(target == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size() - 1);
        return res;
    }
}

public class FindPath {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode l = new TreeNode(5);
        TreeNode r = new TreeNode(12);
        root.left = l;
        root.right = r;
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(7);
        l.left = ll;
        l.right = lr;
        System.out.println(new Solution().FindPath(root, 22));
    }
}
