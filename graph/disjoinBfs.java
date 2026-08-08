import java.util.*;

public class disjoinBfs {
public static class Edge {
    int src,dest,wt;
    Edge(int s, int d,int w){
        src = s;
        dest = d;
        wt = w;
    }
        
    }
    public static void bfs(ArrayList<Edge>[] graph){
         boolean[] vis = new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsTraversalUtil(graph,vis);
            }
        }
    }

    public static void bfsTraversalUtil(ArrayList<Edge>[] graph, boolean[] vis){
        Queue<Integer> qu =new LinkedList<>();
       
        qu.add(0); //adding source
        while (!qu.isEmpty()) {
            int curr = qu.remove();
            if(!vis[curr]){
                vis[curr] = true;
                System.out.println(curr);
                for(int i=0;i<graph[curr].size();i++){
                    qu.add(graph[curr].get(i).dest);
                }
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

     


        //bfs
        bfs(graph);
    }
}
