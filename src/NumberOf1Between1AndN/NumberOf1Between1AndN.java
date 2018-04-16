package NumberOf1Between1AndN;
//求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
// ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数

//总结一下以上的算法，可以看到，当计算右数第 i 位包含的 X 的个数时：
//
//    1.取第 i 位左边（高位）的数字，乘以 10^(i−1)，得到基础值 a。
//    2.取第 i 位数字，计算修正值：
//        如果大于 X，则结果为 a+10^(i−1)。
//        如果小于 X，则结果为 a。
//        如果等 X，则取第 i 位右边（低位）数字，设为 b，最后结果为 a+b+1。

class Solution{
    public int NumberOf1Between1AndN(int n){
        int res = 0;
        for(int i = 1; i <= n; i *= 10){
            int a = n / i;
            int b = n % i;
            res += (a + 8) / 10 * i + ((a % 10) == 1 ? b + 1 : 0);
        }
        return res;
    }
}

public class NumberOf1Between1AndN {
    public static void main(String[] args){
        System.out.println(new Solution().NumberOf1Between1AndN(21345));
    }
}
