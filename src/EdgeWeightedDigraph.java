import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private final int V;
    private int E;
    private List<DirectedEdge>[] adj;
    private int[] indegree;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.indegree = new int[V];
        adj = (List<DirectedEdge>[]) new ArrayList[V];
        for (int v = 0; v < V; v++)
            adj[v] = new ArrayList<DirectedEdge>();
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        indegree[e.to()]++;
        E++;
    }

    public Iterable<DirectedEdge> adj(int v) { return adj[v]; }

    public int outdegree(int v) { return adj[v].size(); }
    public int indegree(int v) { return indegree[v]; }
}