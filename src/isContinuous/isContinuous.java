package isContinuous;
//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，Q为12，K为13，而大小王可以看成任意数字。

import java.util.Arrays;

class Solution{
    public boolean isContinous(int[] numbers){
        if(numbers == null || numbers.length == 0)
            return false;
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        for(int i = 0; i < numbers.length && numbers[i] == 0; i ++)
            numberOfZero ++;
        int small = numberOfZero;
        int big = small + 1;
        while(big < numbers.length){
            if(numbers[small] == numbers[big])
                return false;
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big ++;
        }
        return numberOfGap > numberOfZero ? false : true;
    }
}

public class isContinuous {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 6};
        System.out.println(new Solution().isContinous(numbers));
    }
}
