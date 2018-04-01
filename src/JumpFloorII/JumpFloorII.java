package JumpFloorII;

//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
// 求该青蛙跳上一个n级的台阶总共有多少种跳法.
//f(n) = 2^(n - 1)

class Solution{
    public int JumpFloorII(int target){
        if(target <= 1)
            return 1;
        int f = 1;
        for(int i = 1; i <= target - 1; i ++)
            f *= 2;
        return f;
    }
}

public class JumpFloorII {
    public static void main(String[] args){
        System.out.println(new Solution().JumpFloorII(4));
    }
}
