package minNumberInRotateArray;

class Solution1{
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0)
            return 0;
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1])
                return array[i];
        }
        return array[0];
    }
}

class Solution2 {
    public int minNumberInRotateArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        int mid = -1;
        while (array[left] >= array[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = left + (right - left) / 2;
            if (array[left] <= array[mid])
                left = mid;
            else
                right = mid;
        }
        return array[mid];
    }
}

public class minNumberInRotateArray {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 1, 2};
        Solution1 s1 = new Solution1();
        Solution2 s2 = new Solution2();
        s1.minNumberInRotateArray(array);
        s2.minNumberInRotateArray(array);
    }

}

