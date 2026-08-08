import java.util.*;

public class disjoinDfs {
    public static class Edge {
    int src,dest,wt;
    Edge(int s, int d,int w){
        src = s;
        dest = d;
        wt = w;
    }
        
    }
   public static boolean vis[];
   public static void dfs(ArrayList<Edge>[] graph){
    for(int i=0;i<graph.length;i++){
        if(!vis[i]){
            dfsTraversalUtil(graph, i);
        }
    }
   }

    public static void dfsTraversalUtil(ArrayList<Edge>[] graph, int curr){
        vis[curr]= true;
        System.out.println(curr);
        for(int i=0;i<graph[curr].size();i++){
            if(!vis[graph[curr].get(i).dest]){
                dfsTraversalUtil(graph, graph[curr].get(i).dest);
            }
        }
    }






    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge>[] graph = new ArrayList[V]; 

        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        graph[4].add(new Edge(4, 2, 2));

   vis = new boolean[V];
   dfs(graph);

// System.out.println(hasPath(graph,0,5));
    }
}
