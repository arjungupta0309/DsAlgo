import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by arjun on 16/03/19.
 */
/*graph is created and check if the graph is tree or not
Graph is not a tree if
1. it contains a cycle
2. if is not connected
 */
public class Graph {

    int V;
    LinkedList<Integer> adj[] = null;

    Graph(int V){
        this.V=V;
        adj = new LinkedList[V];
        for (int i=0;i<V;i++){
            adj[i] = new LinkedList<>();
        }
    }

    void addEdgeUndirected(int u, int v){
        adj[u].add(v);
        adj[v].add(u);
    }

    void addEdgeDirected(int src, int dest){
        adj[src].add(dest);
    }

/*find whether a graph is a tree*/
    boolean isTree(){
        boolean[] visited = new boolean[V];

        boolean iscyclic = isCyclic(0, -1, visited);
        if (iscyclic) return false;

        //chk if graph is connected
        for (int i=0;i<V;i++){
             if (!visited[i]) return false;
        }

        return true;
    }
    //time complexity: O(V+E)

    boolean isCyclic(int v, int parent, boolean[] visited){
        visited[v] = true;
        Iterator<Integer> itr = adj[v].iterator();
        while (itr.hasNext()){
            int adjVertex = itr.next();
            if (!visited[adjVertex]){
                boolean flag = isCyclic(adjVertex, v, visited);
                if (flag) return flag;
            }
            else if (adjVertex != parent){
                return true;
            }
        }

        return false;
    }

    //BFS
    void BFS(int src){
        boolean[] visited = new boolean[V];
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int v = queue.poll();
            System.out.print(v+"\t");
            Iterator<Integer> itr = adj[v].iterator();
            while (itr.hasNext()){
                v = itr.next();
                if (!visited[v]){
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }
    //time complexity: O(V+E)

    //DFS
    void DFS(int src){
        boolean visited[] = new boolean[V];
        DFSUtil(src, visited);
    }

    void DFSUtil(int v, boolean[] visited){
        visited[v] = true;
        System.out.print(v+"\t");
        Iterator<Integer> iterator = adj[v].iterator();
        while (iterator.hasNext()){
            int adj = iterator.next();
            if (!visited[adj]){
                DFSUtil(adj, visited);
            }
        }
    }
    //time complexity: O(V+E)

    public static void main(String[] a){
        Graph graph1 = new Graph(5);
        graph1.addEdgeUndirected(0,1);
        graph1.addEdgeUndirected(0,2);
        graph1.addEdgeUndirected(0,3);
        graph1.addEdgeUndirected(3,4);
        System.out.println("graph is tree: "+ graph1.isTree());

        Graph graph2 = new Graph(5);
        graph2.addEdgeUndirected(0,1);
        graph2.addEdgeUndirected(0,2);
        graph2.addEdgeUndirected(0,3);
        graph2.addEdgeUndirected(1,2);
        graph2.addEdgeUndirected(3,4);
        System.out.println("graph is tree: "+ graph2.isTree());

        Graph directedGraph1 = new Graph(5);
        directedGraph1.addEdgeDirected(0,1);
        directedGraph1.addEdgeDirected(0,2);
        directedGraph1.addEdgeDirected(0,3);
        directedGraph1.addEdgeDirected(2,4);
        System.out.print("BFS of the graph : ");
        directedGraph1.BFS(0);

        Graph directedGraph2 = new Graph(4);
        directedGraph2.addEdgeDirected(0,1);
        directedGraph2.addEdgeDirected(0,2);
        directedGraph2.addEdgeDirected(1,2);
        directedGraph2.addEdgeDirected(2,0);
        directedGraph2.addEdgeDirected(2,3);
        directedGraph2.addEdgeDirected(3,3);
        System.out.print("DFS of the graph : ");
        directedGraph2.DFS(2);
    }


}
