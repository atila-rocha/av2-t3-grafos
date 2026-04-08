import java.util.Iterator;
import java.util.Stack;
import java.util.LinkedList;
import java.util.List;

public class DirectedEulerianCycle {
    private List<Integer> cycle = new LinkedList<>();
    private double totalWeight = 0;

    @SuppressWarnings("unchecked")
    public DirectedEulerianCycle(EdgeWeightedDigraph G) {
        // 1. Verifica se o grafo é balanceado
        for (int v = 0; v < G.V(); v++) {
            if (G.outdegree(v) != G.indegree(v)) return;
        }

        // 2. Calcula o custo total
        for (int v = 0; v < G.V(); v++) {
            for (DirectedEdge e : G.adj(v)) {
                totalWeight += e.weight();
            }
        }

        // 3. Prepara iteradores locais
        Iterator<DirectedEdge>[] adj = (Iterator<DirectedEdge>[]) new Iterator[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = G.adj(v).iterator();
        }

        // 4. Algoritmo de Hierholzer
        Stack<Integer> dfs = new Stack<>();
        int s = 0; // Ponto de partida (Vértice 'a')
        dfs.push(s);

        while (!dfs.isEmpty()) {
            int v = dfs.peek();
            if (adj[v].hasNext()) {
                DirectedEdge e = adj[v].next();
                dfs.push(e.to());
            } else {
                // Aqui está a mágica que estava faltando: salva o vértice no ciclo
                cycle.add(0, dfs.pop());
            }
        }
    }

    public Iterable<Integer> cycle() { return cycle; }
    public double totalWeight() { return totalWeight; }
    public boolean hasEulerianCycle() { return !cycle.isEmpty(); }
}