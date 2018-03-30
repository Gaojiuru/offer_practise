package mergrTwoArrays;
//合并两个排序数组A1和A2，存储在A1数组中

public class mergeTwoArrays {
    public static void main(String[] args){
        int[] A2 = {2, 4, 7, 9};
        int[] a = {1, 2, 3, 4, 8};
        int[] A1 = new int[A2.length + a.length];
        System.arraycopy(a, 0, A1, 0, a.length);
        int index = A1.length - 1;
        int indexI = a.length - 1;
        int indexJ = A2.length - 1;
        while(indexI >= 0 && indexJ >= 0)
            A1[index--] = A1[indexI] > A2[indexJ] ? A1[indexI --] : A2[indexJ --];
        while(indexJ > 0)
            A1[index --] = A2[indexJ --];

        for(int i = 0; i < A1.length; i ++)
            System.out.print(A1[i] + "\t");
    }
}
