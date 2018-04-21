package Add;
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号

class Solution{
    public int Add(int num1, int num2){
        int sum;
        int carry;
        do{
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }while(num2 != 0);
        return num1;
    }
}

public class Add {
    public static void main(String[] args){
        System.out.println(new Solution().Add(5, 17));
    }
}
