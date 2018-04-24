package graph;
//输入:第一行是一个整数T，表示有T组测试样例(0 < T <= 50)。每个测试样例开始一行包括两个整数N，M，(0 < N <= 20,0 <= M <= 200)
//分别代表N个顶点，和M条边。下面的M行，每行有两个整数u，v，顶点u和顶点v相连。
//输出:每行一个整数，连通分量个数。

import java.util.Scanner;

class Solution{
    public int find(int a, int[] pre){
        if(pre[a] != a)
            pre[a] = find(pre[a], pre);
        return pre[a];
    }

    public void join(int x, int y, int[] pre){
        int fx = find(x, pre);
        int fy = find(y, pre);
        if(fx != fy)
            pre[fy] = fx;
    }
}


public class graph {
    public static void main(String[] args){
        int num = 0;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Solution s = new Solution();
        int[] pre = new int[N + 1];
        for(int i = 1; i <= N; i ++)
            pre[i] = i;
        for(int i = 1; i <= M; i ++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            s.join(a, b, pre);
        }

        for(int i = 1; i <= N; i ++)
            if(pre[i] == i)
                num ++;
        System.out.println(num);
    }
}
