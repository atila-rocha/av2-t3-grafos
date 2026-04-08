import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String path = "dados/suposta_entrada_eulerizada";

        try {
            Scanner sc = new Scanner(new File(path));
            int V = sc.nextInt();
            int E = sc.nextInt();

            EdgeWeightedDigraph G = new EdgeWeightedDigraph(V);

            for (int i = 0; i < E; i++) {
                int v = sc.nextInt();
                int w = sc.nextInt();
                double weight = sc.nextDouble();
                G.addEdge(new DirectedEdge(v, w, weight));
            }

            System.out.println("=== Verificação de Graus ===");
            boolean balanceado = true;
            for (int v = 0; v < G.V(); v++) {
                char letra = (char) ('a' + v);
                System.out.printf("Vértice %c: Entrada=%d, Saída=%d\n",
                        letra, G.indegree(v), G.outdegree(v));

                if (G.indegree(v) != G.outdegree(v)) balanceado = false;
            }

            if (balanceado) {
                System.out.println("\nO grafo está balanceado! Existe circuito euleriano.");

                DirectedEulerianCycle euler = new DirectedEulerianCycle(G);

                if (euler.hasEulerianCycle()) {
                    System.out.print("Circuito Euleriano: ");
                    // Transforma os números salvos no ciclo de volta em letras
                    for (int v : euler.cycle()) {
                        char verticeLetra = (char) ('a' + v);
                        System.out.print(verticeLetra + " ");
                    }
                    System.out.println();
                    System.out.println("Custo Total do Circuito: " + euler.totalWeight());
                } else {
                    System.out.println("Erro interno: Ciclo não pôde ser formado.");
                }

            } else {
                System.out.println("\nO grafo NÃO está balanceado.");
            }

            sc.close();
        } catch (Exception e) {
            System.out.println("Erro ao executar: " + e.getMessage());
        }
    }
}