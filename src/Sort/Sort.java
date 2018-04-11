package Sort;
//八大排序算法

class Solution{
    //直接插入排序
    public void insertsort(int[] a){
        int v, j;
        for(int i = 1; i < a.length; i ++){
            for(v = a[i], j = i - 1; j >= 0 && v < a[j]; j --)
                    a[j + 1] = a[j];
                a[j + 1] = v;
        }
    }
    //希尔排序
    public void shellSort(int[] a){
        int v, j;
        for(int dk = a.length / 2; dk >= 1; dk /= 2) {
            for (int i = dk; i < a.length; i++) {
                v = a[i];
                for (j = i - dk; j >= 0 && v < a[j]; j -= dk) {
                    a[j + dk] = a[j];
                }
                a[j + dk] = v;
            }
        }
    }
    //直接选择排序
    public void selectionSort(int[] a){
        int j, pos;
        for(int i = 0; i < a.length - 1; i ++){
            for(pos = i, j = i + 1; j < a.length; j ++){
                if(a[pos] > a[j])
                    pos = j;
            }
            if(pos != i){
                int temp = a[i];
                a[i] = a[pos];
                a[pos] = temp;
            }
        }
    }

    //冒泡排序
    public void bubbleSort(int[] a){
        int i, j, lastSwap;
        for(j = a.length - 1; j > 0; j = lastSwap){
            lastSwap = 0;
            for(i = 0; i < j; i ++){
                if(a[i] > a[i + 1]){
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    lastSwap = i;
                }
            }
        }
    }

    //快速排序
    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private int partition(int[] a, int left, int right){
        int pos = right;
        right --;
        while(left <= right){
            while(left < pos && a[left] <= a[pos])
                left ++;
            while(left < right && a[right] >= a[pos])
            if(left >= right)
                break;
            swap(a, left, right);
        }
        swap(a, left, pos);
        return left;
    }

    public void quickSort(int[] a, int left, int right){
        if(left > right)
            return;
        int index = partition(a, left, right);
        quickSort(a, left, index - 1);
        quickSort(a, index + 1, right);
    }

    //堆排序
    private void adjustHeap(int[] a, int i, int len){
        int j, temp;
        temp = a[i];
        for(j = 2 * i; j < len; j *= 2){
            if(j < len && a[j] < a[j + 1])
                j ++;
            if(temp >= a[j])
                break;
            a[i] = a[j];
            i = j;
        }
        a[i] = temp;
    }

    public void heapSort(int[] a){
        int i;
        for(i = a.length / 2 - 1; i >= 0; i --)
            adjustHeap(a, i, a.length - 1);
        for(i = a.length - 1; i >= 0; i --){
            swap(a, 0, i);
            adjustHeap(a, 0 , i - 1);
        }
    }

    //归并排序
    private void merge(int[] a, int low, int mid, int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while(i <= mid && j <= high){
            if(a[i] < a[j])
                temp[k ++] = a[i ++];
            else
                temp[k ++] = a[j ++];
        }
        while(i <= mid)
            temp[k ++] = a[i ++];
        while(j <= high)
            temp[k ++] = a[j ++];

        for(int x = 0; x < temp.length; x ++)
            a[x + low] = temp[x];
    }

    public void mergeSort(int[] a, int low, int high){
        int mid = (low + high) / 2;
        if(low < high){
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
}


public class Sort {
    private static void printArrays(int[] a){
        for(int i = 0; i < a.length; i ++)
            System.out.print(a[i] + "\t");
        System.out.println();
    }


    public static void main(String[] args){
        int[] a = {3,1,5,7,2,4,9,6};
        //new Solution().insertsort(a);
        //new Solution().shellSort(a);
        //new Solution().selectionSort(a);
        //new Solution().bubbleSort(a);
        //new Solution().quickSort(a, 0, a.length - 1);
        //new Solution().heapSort(a);
        new Solution().mergeSort(a, 0, a.length - 1);
        printArrays(a);
    }
}
