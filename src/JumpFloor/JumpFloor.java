package JumpFloor;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法

class Solution1 {
    public int JumpFloor(int target) {
        if (target == 0)
            return 1;
        if (target == 1)
            return 1;
        if (target == 2)
            return 2;
        else
            return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}

class Solution2 {
    public int JumpFloor(int target) {
        if (target <= 1)
            return 1;
        if (target == 2)
            return 2;
        int f1 = 1;
        int f2 = 2;
        int f = 0;
        for (int i = 2; i < target; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}

public class JumpFloor {
    public static void main(String[] args){
        System.out.println(new Solution1().JumpFloor(13));
        System.out.println(new Solution2().JumpFloor(13));
    }
}
