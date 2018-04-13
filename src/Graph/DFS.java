package Graph;

import java.util.Scanner;

//存储边
class EdgeNode{
    int adjVertex;
    int value;
    EdgeNode nextArc;//指向下一条弧
}

//邻接表节点
class VertexNode{
    String name;
    EdgeNode firstArc = new EdgeNode();//指向第一条弧
}

class Graph{
    VertexNode[] adjList;
    int e;
    int v;
    boolean[] visit;

    public Graph(int v, int e){
        this.v = v;
        this.e = e;
        adjList = new VertexNode[e + 1];
        visit = new boolean[e + 1];
        for(int i= 0; i < e; i ++){
            visit[i] = false;
        }
    }
}

class CreateGraph{
    private static Graph G;
    public static Graph getGraph(){
        return G;
    }

    private int Index(String e){
        for(int i = 0; i < G.v; i ++){
            if(G.adjList[i].name.equals(e))
                return i;
        }
        return -1;
    }

    public void creategraph(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入顶点数v和边数e：");
        int v = sc.nextInt();
        int e = sc.nextInt();
        G = new Graph(v, e);
        for(int i = 0; i < G.v; i ++){
            G.adjList[i] = new VertexNode();
            G.adjList[i].name = sc.next();
            G.adjList[i].firstArc = null;
        }

        for(int i = 0; i < G.e; i ++){
            EdgeNode edge1 = new EdgeNode();
            String e1 = sc.next();
            String e2 = sc.next();
            int v1 = Index(e1);
            int v2 = Index(e2);
            edge1.adjVertex = v1;
            edge1.nextArc = G.adjList[v2].firstArc;
            G.adjList[v2].firstArc = edge1;

            EdgeNode edge2 = new EdgeNode();
            edge2.adjVertex = v2;
            edge2.nextArc = G.adjList[v1].firstArc;
            G.adjList[v1].firstArc = edge2;
        }
    }

    public void outputGraph(){
        try {
            System.out.println("输出邻接表存储情况：");
            EdgeNode en = new EdgeNode();
            for (int i = 0; i < G.e; i++) {
                System.out.print(G.adjList[i].name);
                en = G.adjList[i].firstArc;
                while (en != null) {
                    System.out.print("->" + G.adjList[en.adjVertex].name);
                    en = en.nextArc;
                }
                System.out.println();
            }
        }
        catch (NullPointerException e) {

        }
    }
}

class DFSGraph{
    public void DFSGraph(Graph G, int k){
        System.out.println(G.adjList[k].name);
        G.visit[k] = true;
        EdgeNode p = new EdgeNode();
        p = G.adjList[k].firstArc;
        while(p!=null){
            if(G.visit[p.adjVertex]!=true){
                DFSGraph(G, p.adjVertex);
            }
            p = p.nextArc;
        }
    }
}

public class DFS {
    public static void main(String[] args){
        CreateGraph test = new CreateGraph();
        test.creategraph();
        test.outputGraph();
        Graph G = test.getGraph();
        DFSGraph dfs = new DFSGraph();
        dfs.DFSGraph(G, 0);
    }
}
