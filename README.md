T3 — Problema do Carteiro Chinês

Implementação: Java

Descrição do Problema
O Problema do Carteiro Chinês consiste em encontrar o menor percurso fechado que passe por todas as arestas de um grafo pelo menos uma vez. Em um dígrafo ponderado, isso exige que o grafo seja euleriano, ou seja, que todos os vértices estejam balanceados (grau de entrada igual ao grau de saída).

Quando o grafo original não é euleriano, é necessário eulerizar o grafo: identificar os vértices desbalanceados e adicionar arestas (repetindo caminhos já existentes) até que o balanceamento seja atingido.

Arestas Acrescentadas
Para balancear o grafo, foram adicionadas arestas correspondentes a caminhos já existentes no dígrafo original. As arestas repetidas foram escolhidas de forma a corrigir o desbalanceamento com o menor custo adicional possível, respeitando a estrutura do grafo.
As inserções realizadas estão representadas no arquivo dados/entrada_eulerizada.txt.

Vídeo Explicativo
https://youtu.be/IZbmkJWDQmQ