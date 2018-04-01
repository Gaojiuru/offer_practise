package NumberOf1;

//输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

class Solution1{
    public int NumberOf1(int n){
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0)
                count ++;
            flag = flag << 1;
        }
        return count;
    }
}

class Solution2{
    public int NumberOf1(int n){
        int count = 0;
        while(n != 0){
            count ++;
            n = (n - 1) & n;
        }
        return count;
    }
}

public class NumberOf1 {
    public static void main(String[] args){
        System.out.println(new Solution1().NumberOf1(9));
        System.out.println(new Solution2().NumberOf1(9));
    }
}
