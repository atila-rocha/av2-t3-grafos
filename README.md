# T3 — Problema do Carteiro Chinês

> Implementação: Java

# Descrição do Problema
O Problema do Carteiro Chinês consiste em encontrar o menor percurso fechado que passe por todas as arestas de um grafo pelo menos uma vez. Em um dígrafo ponderado, isso exige que o grafo seja euleriano, ou seja, que todos os vértices estejam balanceados (grau de entrada igual ao grau de saída).

Quando o grafo original não é euleriano, é necessário eulerizar o grafo: identificar os vértices desbalanceados e adicionar arestas (repetindo caminhos já existentes) até que o balanceamento seja atingido.

Arestas Acrescentadas
Para balancear o grafo, foram adicionadas arestas correspondentes a caminhos já existentes no dígrafo original. As arestas repetidas foram escolhidas de forma a corrigir o desbalanceamento com o menor custo adicional possível, respeitando a estrutura do grafo.
As inserções realizadas estão representadas no arquivo dados/entrada_eulerizada.txt.

## Vídeo Explicativo
Link: https://youtu.be/IZbmkJWDQmQ

# Como rodar:

## Usando IntelliJ (recomendado)

1. Clone o repo usando o comando:
   1. `git clone (link do repo)`
2. Abra o IntelliJ e abra a pasta do repositório clonado
3. Clique no botão "Run" na tecla acima ou use o atalho `Ctrl + F5`

## Via terminal

Use o seguinte comando:

`java .\src\Main.java`

Esse comando compilará e primeiramente emitirá *warnings*, após isso, ele executa a Main.java perfeitamente

# Troubleshooting

> Estou tendo problemas para rodar o IntelliJ

- Verifique se você está usando o JDK 25 (25.0.1)
  - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
  - Após isso clique em `File`
  - Em seguida clique em `Project Structure`
  - Ao clicar, vai abrir uma janela, depois clique em `project`, no canto esquerdo da janela
  - Teste rodar
- Veja se a IDE (IntelliJ está reconhecendo o source)
  - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
     - Após isso clique em `File`
     - Em seguida clique em `Project Structure`
     - Ao clicar, vai abrir uma janela, depois clique em `Modules`, no canto esquerdo da janela
     - Após isso, no centro da janela haverá os diretórios do projeto, selecione a pasta `src`
     - Em cima desses diretórios tem uns um texto chamado `Mark as`, depois de localizar, selecione `Sources`, ao lado de "Mark as"
     - Teste rodar

## Soluções genéricas
1. Rebuild seu preojeto
2. Pressione `Ctrl + Alt + Y` para fazer o Reload de tudo do Disk
3. Use o botão `Repair IDE`, localizado no menu File, no menu principal

> - No IntellJ, clique no botão menu (4 linhas na horizontal empilhadas uma em cima da outra) no canto superior esquerdo
> Após isso clique em `File` e selecione `Repair IDE`