package GetNumberOfK;
//统计一个数字在排序数组中出现的次数。

class Solution1{
    public int GetNumberOfK(int[] array, int k){
        int i = 0;
        int j = array.length - 1;
        int count = 0;
        while(i <= j){
            if(array[i] == k && array[j] == k) {
                count = j - i + 1;
                break;
            }
            else if(array[i] == k && array[j] != k)
                j --;
            else if(array[i] != k && array[j] == k)
                i ++;
            else{
                i ++;
                j --;
            }

            if(i > j)
                break;
        }
        return count;
    }
}

class Solution2{
    public int GetNumberOfK(int[] array, int k){
        int count = 0;
        if(array != null && array.length > 0){
            int first = GetFirstK(array, 0, array.length - 1, k);
            int last = GetLastK(array, 0, array.length - 1, k);
            if(first > -1 && last > -1)
                count = last - first + 1;
        }
        return count;
    }

    private int GetFirstK(int[] array, int low, int high, int k){
        if(low > high)
            return -1;
        int mid = (low + high) >> 1;
        if(array[mid] == k){
            if((mid > 0 && array[mid - 1] != k) || mid == 0)
                return mid;
            else high = mid - 1;
        }
        else if(array[mid] > k)
            high = mid - 1;
        else
            low = mid + 1;

        return GetFirstK(array, low, high, k);
    }

    private int GetLastK(int[] array, int low, int high, int k){
        if(low > high)
            return - 1;
        int mid = (low + high) >> 1;
        if(array[mid] == k){
            if(mid == array.length - 1 || (mid > 0 && array[mid + 1] != k))
                return mid;
            else
                low = mid + 1;
        }
        else if(array[mid] > k)
            high = mid - 1;
        else
            low = mid + 1;

        return GetLastK(array, low, high, k);
    }
}

public class GetNumberOfK {
    public static void main(String[] args){
        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        int k = 6;
        System.out.println(new Solution2().GetNumberOfK(array, k));
    }
}
