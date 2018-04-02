package Print1ToMaxOfNDigits;

//输入数字n，按顺序打印出从1最大的n位十进制数。
//输入3，则打印出1、2、3一直到最大的三位数999。

class Solution{
    public void Print1ToMaxOfNDigits(int n){
        if(n <= 0)
            return;
        int[] number = new int[n];
        for(int i = 0; i < 10; i ++){
            number[0] = i;
            Print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    private void Print1ToMaxOfNDigitsRecursively(int[] number, int length, int index){
        if(index == length - 1) {
            print(number);
            return;
        }
        for(int i = 0; i < 10; i ++){
            number[index + 1] = i;
            Print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    private void print(int[] number){
        boolean isBeginning0 = true;
        for(int i = 0; i < number.length; i ++){
            if(isBeginning0 && number[i] != 0)
                isBeginning0 = false;
            if(!isBeginning0)
                System.out.print(number[i]);
        }
    }
}

public class Print1ToMaxOfNDigits {
    public static void main(String[] args){
        new Solution().Print1ToMaxOfNDigits(3);
    }
}
