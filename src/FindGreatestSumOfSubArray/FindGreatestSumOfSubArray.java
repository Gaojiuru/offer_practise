package FindGreatestSumOfSubArray;
//求联系子向量最大和

class Solution{
    public int FindGreatestSumOfSubArray(int[] array){
        if(array == null || array.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < array.length; i ++) {
            if(sum <= 0)
                sum = array[i];
            else
                sum += array[i];

            max = Math.max(sum, max);
        }
        return max;
    }
}

public class FindGreatestSumOfSubArray {
    public static void main(String[] args){
        int[] array = {2, 8, 1, 5, 9};
        System.out.println(new Solution().FindGreatestSumOfSubArray(array));
    }
}
