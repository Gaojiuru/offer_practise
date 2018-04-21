package FindNumAppearOnce_2;
//一个数组中除了一个数字出现一次外，其它数字均出现三次，求只出现一次的数

class Solution{
    public int FindAppearOnce(int[] array) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++)
            bits[i] = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < 32; j++)
                bits[j] += ((array[i] >> j) & 1);

        int result = 0;
        for (int i = 0; i < 32; i++)
            if (bits[i] % 3 != 0)
                result += (1 << i);
        return result;
    }
}

public class FindNumAppearOnce {
        public static void main(String[] args){
            int[] array = {1, 4, 2, 1, 4, 1, 4};
            System.out.println(new Solution().FindAppearOnce(array));
        }
}
