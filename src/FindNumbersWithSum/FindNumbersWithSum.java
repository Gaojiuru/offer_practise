package FindNumbersWithSum;
//输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

import java.util.ArrayList;

class Solution{
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum){
        ArrayList<Integer> res = new ArrayList<>();
        int small = 0;
        int big = array.length - 1;
        while(small < big){
            if(array[small] + array[big] == sum) {
                res.add(array[small]);
                res.add(array[big]);
                break;
            }
            else if(array[small] + array[big] < sum)
             small ++;
            else
                big --;
        }
        return res;
    }
}

public class FindNumbersWithSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 11, 14, 15};
        int sum = 15;
        System.out.println(new Solution().FindNumbersWithSum(array, sum));
    }
}
