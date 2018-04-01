package RectCover;

//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？

class Solution1{
    public int RectCover(int target){
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        return RectCover(target - 1) + RectCover(target - 2);
    }
}

class Solution2{
    public int RectCover(int target){
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        int f1 = 0;
        int f2 = 1;
        int f = 0;
        while(target -- != 0) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}

public class RectCover {
    public static void main(String[] args){
        System.out.println(new Solution1().RectCover(4));
        System.out.println(new Solution2().RectCover(4));
    }

}
