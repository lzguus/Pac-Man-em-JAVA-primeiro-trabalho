import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Labirinto {
// Matriz de celulas do labirinto

    private final Celula[][] tabuleiro;
    private final int qtdLinhas;
    private final int qtdColunas;



// Construtor do labirinto com a quantidade de linhas e colunas
    public Labirinto(int linhas, int colunas) {
        this.qtdLinhas = linhas;
        this.qtdColunas = colunas;
        
        tabuleiro = new Celula[linhas][colunas];



// Inicializa as celulas do labirinto com um loop
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                tabuleiro[i][j] = new Celula(i, j);
            }
        }
    }



// Gera o labirinto usando o algoritmo de backtracking 
    public void gerar() {
Random sorteio = new Random(); // Gerador de numeros aleatorios para o labirinto
List<Celula> caminho = new ArrayList<>(); // Esta Lista funciona como "Pilha" ou "Memória"




// Marca a celula inicial como visitada 
Celula celulaInicial = tabuleiro[0][0];
celulaInicial.setVisitada(true);
caminho.add(celulaInicial);


// LOOP PRINCIPAL: Enquanto tivermos um "rastro" na memória, continuamos trabalhando
while (!caminho.isEmpty()) {
    Celula atual = caminho.get(caminho.size() - 1); 



// REGRA 1:(Evita Loops)
// Buscamos apenas vizinhos que ainda nao foram visitados
// Se entrar em vizinhos visitados, iria criar um ciclo no labirinto.
List<Celula> vizinhos = listarVizinhosLivres(atual);



// Se tiver vizinhos livres
    if (!vizinhos.isEmpty()) { //Aqui ele inicia a busca por caminhos novos, com o uso do DFS



// Sorteia um vizinho aleatoriamente pra onde ir, se é em cima, baixo, esquerda ou direita//
int indiceSorteado = sorteio.nextInt(vizinhos.size());
Celula proxima = vizinhos.get(indiceSorteado);


// "Quebra a Parede": Muda o boolean para false, criando a passagem visual
abrirPassagem(atual, proxima);




//3. Memoria: Marca como visitada e ADICIONA na lista (pilha)
//Salva pra se precisar voltar depois
proxima.setVisitada(true);
caminho.add(proxima); // eh o que faz ele ir se aprofundando no labirinto


    } else {


//Backtracking   
//(Evita Ilhas)
// Se chegamos num beco sem saída, volta
// Removemos a célula atual da lista para "voltar um passo atrás"
// e verificar se o passo anterior tem outros caminhos para explorar.
caminho.remove(caminho.size() - 1);
        }
    }
}


// Verifica os vizinhos nao visitados
private List<Celula> listarVizinhosLivres(Celula c) {
    List<Celula> lista = new ArrayList<>();
    int lin = c.getLinha();
    int col = c.getColuna();



// Verifica cima se nao foi visitado
if (lin > 0) {
    Celula vizinhoCima = tabuleiro[lin - 1][col];
    if (!vizinhoCima.isVisitada()) {
    lista.add(vizinhoCima);

        }

    }
// Verifica embaixo se nao foi visitado
if (lin < qtdLinhas - 1) {
    Celula vizinhoBaixo = tabuleiro[lin + 1][col];
if (!vizinhoBaixo.isVisitada()) {

        lista.add(vizinhoBaixo);

            }
        }
// Verifica esquerda e direita se nao foi visitado
if (col > 0) {
    Celula vizinhoEsq = tabuleiro[lin][col - 1];
    if (!vizinhoEsq.isVisitada()) {
    lista.add(vizinhoEsq);
            }
        }

// Verifica direita se nao foi visitado 
if (col < qtdColunas - 1) {
    Celula vizinhoDir = tabuleiro[lin][col + 1];
if (!vizinhoDir.isVisitada()) {
    lista.add(vizinhoDir);
            }
        }


//(if = Avanço, else = Retrocesso).
        return lista;
    }



// Abre a passagem entre duas celulas
    private void abrirPassagem(Celula c1, Celula c2) {


// Se o c2 estiver abaixo do c1
if (c1.getLinha() < c2.getLinha()) {



// Abre a passagem entre as duas celulas
c1.setParedeBaixo(false);
    c2.setParedeCima(false);
        }

// Se o c2 estiver acima do c1
else if (c1.getLinha() > c2.getLinha()) {

// Abre a passagem entre as duas celulas
c1.setParedeCima(false);
    c2.setParedeBaixo(false);
        }
// Abre a passagem pra direita
else if (c1.getColuna() < c2.getColuna()) {

    c1.setParedeDireita(false);
        c2.setParedeEsquerda(false);
        }


// Abre a passagem pra esquerda
else if (c1.getColuna() > c2.getColuna()) {
    c1.setParedeEsquerda(false);
        c2.setParedeDireita(false);
        }
    }


// Pega a celula na posicao linha/coluna e retorna ela
    public Celula getCelula(int l, int c) {
        return tabuleiro[l][c];// Retorna a celula na posiçao l,c
    }


// Pega a quantidade de linhas e colunas  e retorna elas
    public int getQtdLinhas() { return qtdLinhas; }
    public int getQtdColunas() { return qtdColunas; }



//Coloca o jogo com F, J e as comidas na saida do labirinto
public void imprimirEstado(Personagem jogador, Personagem fantasma) {
        
    for (int i = 0; i < qtdLinhas; i++) {

    for (int j = 0; j < qtdColunas; j++) {

System.out.print("+");

// Desenha parede de cima
    if (tabuleiro[i][j].isParedeCima()) { 
System.out.print("---");
// Se nao tiver parede
    } else {
    System.out.print("   ");
                }
}
// Fecha a linha de cima
    System.out.println("+");

for (int j = 0; j < qtdColunas; j++) {
    if (tabuleiro[i][j].isParedeEsquerda()) {

//Desenha parede da esquerda
System.out.print("|");

    } else {
// Sem parede
System.out.print(" ");
     }



     
// Verifica se tem jogador, fantasma ou comida na celula
boolean temJogador = (jogador.getLinha() == i && jogador.getColuna() == j);

// Verifica se tem fantasma na celula
boolean temFantasma = (fantasma.getLinha() == i && fantasma.getColuna() == j);


// Verifica se tem comida na celula
boolean temComida = tabuleiro[i][j].isTemAlimento(); 


// Se tiver jogador e fantasma na mesma celula
if (temJogador && temFantasma) {

//Imprime que os dois estao na mesma célula
System.out.print("JF "); 

} else if (temFantasma) {
//Tem fantasma e comida na mesma celula
    if (temComida) System.out.print("Fo ");

//So tem o fantasma
else System.out.print(" F "); 
    } else if (temJogador) {

//So tem o jogador
System.out.print(" J "); 
    } else if (temComida) {

//So tem a comida
System.out.print(" o "); 
    } else {

//Celula vazia
System.out.print("   "); 
    }
        }
// Fecha a linha da direita
System.out.println("|");
        }

for (int j = 0; j < qtdColunas; j++) {
// Desenha parede de baixo
    System.out.print("+---");
        }
// Fecha o canto inferior direito
System.out.println("+");
    }
}