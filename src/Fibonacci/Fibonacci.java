package Fibonacci;
//大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39

class Solution1{
    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        else
            return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}

class Solution2 {
    public int Fibonacci(int n) {
        int g = 1, f = 0;
        while (n-- != 0) {
            g += f;
            f = g - f;
        }
        return f;
    }
}

public class Fibonacci {
        public static void main(String[] args){
            System.out.println(new Solution1().Fibonacci(30));
            System.out.println(new Solution2().Fibonacci(30));
        }
}
