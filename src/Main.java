public class Main {

    public static void main(String[] args) {
        // 1. LER O ARQUIVO
        // Certifique-se de que o caminho do arquivo está correto no seu projeto
        String caminhoArquivo = "dados/entrada_eulerizada";
        In in = new In(caminhoArquivo);

        // 2. CONSTRUIR O DÍGRAFO PONDERADO
        EdgeWeightedDigraph digraph = new EdgeWeightedDigraph(in);

        System.out.println("=========================================");
        System.out.println("   PROBLEMA DO CARTEIRO CHINÊS");
        System.out.println("=========================================\n");

        System.out.println("Grafo carregado com sucesso!");
        System.out.println("Total de Vértices: " + digraph.V());
        System.out.println("Total de Arestas: " + digraph.E() + "\n");

        // 3. COMPROVAR O BALANCEAMENTO
        System.out.println("--- Verificação de Balanceamento ---");
        boolean balanceado = true;
        for (int v = 0; v < digraph.V(); v++) {
            int grauEntrada = digraph.indegree(v);
            int grauSaida = digraph.outdegree(v);

            System.out.printf("Vértice %d -> Entrada: %d | Saída: %d\n", v, grauEntrada, grauSaida);

            if (grauEntrada != grauSaida) {
                balanceado = false;
            }
        }

        if (!balanceado) {
            System.out.println("\n[ERRO] O grafo não está balanceado! O carteiro vai ficar preso em alguma rua.");
            return; // Encerra o programa
        }
        System.out.println("[OK] O grafo está perfeitamente balanceado!\n");

        System.out.println("REPRESENTAÇÃO DO DÍGRAFO PONDERADO BALANCEADO");
        System.out.println(digraph.toDot());

        // 4. EXECUTAR O ALGORITMO (Método de Hierholzer)
        DirectedEulerianCycle euler = new DirectedEulerianCycle(digraph);

        // 5. IMPRIMIR A ROTA E CALCULAR O CUSTO
        System.out.println("--- Resultado do Trajeto ---");
        if (euler.hasEulerianCycle()) {
            System.out.print("Rota do Carteiro: ");

            // Imprime a sequência de vértices
            for (int v : euler.cycle()) {
                System.out.print(v + " ");
            }
            System.out.println("\n");

            // 6. CALCULAR O CUSTO TOTAL
            // Como é um circuito euleriano, TODAS as arestas são percorridas exatamente uma vez.
            // Portanto, o custo total é simplesmente a soma de todas as arestas do grafo!
            double custoTotal = 0.0;
            for (DirectedEdge e : digraph.edges()) {
                custoTotal += e.weight();
            }

            System.out.printf("Custo Total do Percurso: %.2f\n", custoTotal);

        } else {
            System.out.println("Não foi possível encontrar um circuito euleriano.");
        }

        System.out.println("=========================================");
    }
}