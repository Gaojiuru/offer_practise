package duplicate;
//在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
// 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。

class Solution{
    public boolean duplicate(int numbers[],int length,int [] duplication){
        if(numbers == null || length == 0)
            return false;
        for(int i = 0; i < length; i ++){
            int index = numbers[i];
            if(index < 0)
                index += length;
            if(numbers[index] < 0){
                duplication[0] = numbers[index] + length;
                return true;
            }
            numbers[index] -= length;
        }
        return false;
    }
}
public class duplicate {
    public static void main(String[] args){
        int[] numbers = {2, 6, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplication = new int[1];
        System.out.println(new Solution().duplicate(numbers, length, duplication));
    }
}
