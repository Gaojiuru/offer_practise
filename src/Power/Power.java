package Power;

//给定一个double类型的浮点数base和int类型的整数exponent。
// 求base的exponent次方。

class Solution1{
    public double Power(double base, int exponent){
        double res = 1;
        if(exponent == 0)
            return 1;
        if(exponent < 0) {
            if(equal(base, 0.0))
                return 0;
            else
                return 1.0 / Power(base, 0 - exponent);
        }
        while(exponent >= 1) {
            exponent --;
            res *= base;
        }
        return res;
    }

    private boolean equal(double num1, double num2){
        if(num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001)
            return true;
        else return false;
    }
}

class Solution2{
    public double Power(double base, int exponent) {
        double res = 1;
        if (exponent == 0)
            return 1;
        if (exponent < 0) {
            if (equal(base, 0.0))
                return 0;
            else
                return 1.0 / Power(base, 0 - exponent);
        }
        res =Power(base, exponent >> 1);
        res *= res;
        if(exponent % 2 == 1)
            res *= base;
        return res;
    }

    private boolean equal(double num1, double num2){
        if(num1 - num2 > -0.0000001 && num1 - num2 < 0.0000001)
            return true;
        else return false;
    }
}

public class Power {
    public static void main(String[] args){
        System.out.println(new Solution1().Power(1.2, -5));
        System.out.println(new Solution2().Power(1.2, -5));
    }
}
