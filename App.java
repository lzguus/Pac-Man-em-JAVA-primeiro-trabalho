import java.util.Scanner;

public class App {
public static void main(String[] args) {

Scanner teclado = new Scanner(System.in);

System.out.println("--- JOGO DO PAC-MAN  ---");
System.out.print("Digite a altura do labirinto: ");
    int linhas = teclado.nextInt();

System.out.print("Digite a largura do labirinto: ");
    int colunas = teclado.nextInt();


// Cria e Gera o Labirinto
Labirinto lab = new Labirinto(linhas, colunas);
    lab.gerar();

// Cria os Personagens,jogador começando no canto superior esquerdo (0,0)
    Jogador jogador = new Jogador(); 
        


// Fantasma começa no canto oposto do jogador
    Fantasma fantasma = new Fantasma(linhas - 1, colunas - 1);


// Onde eles nascem nao pode ter comida 
lab.getCelula(0, 0).setTemAlimento(false);
lab.getCelula(linhas - 1, colunas - 1).setTemAlimento(false);



// Variaveis do jogo
    int pontuacao = 0;
    int totalComidas = (linhas * colunas) - 2; // Total de comidas, que tira as posicoes do jogador e do fantasma
    boolean jogoRodando = true; 

// Loop do jogo
    while (jogoRodando) {



// Mostra a pontuaçao e o estado atual do labirinto
System.out.println("\nPontuacao: " + pontuacao + "/" + totalComidas);
    lab.imprimirEstado(jogador, fantasma);


// Mostra os comandos que o jogador pode usar
System.out.print("Mover (w=Cima, s=Baixo, a=Esquerda, d=Direita): ");
    char comando = teclado.next().toLowerCase().charAt(0);



// Le as letras e muda pra direção que o jogador entende
int direcao = 0;
if (comando == 'w') direcao = Paredes.CIMA;
    else if (comando == 's') direcao = Paredes.BAIXO;
    else if (comando == 'a') direcao = Paredes.ESQUERDA;
    else if (comando == 'd') direcao = Paredes.DIREITA;
    else {
//Se o comando for invalido
System.out.println("Comando invalido, use as teclas de mover");
    continue; // Volta pro começo do loop
    }



// Move Jogador
    boolean moveu = jogador.mover(direcao, lab);

    //Se ele mover errado, avisa que tem a parede
    if (!moveu) {

    System.out.println("Tem uma parede, tente outro lado.");
    continue; 
            }



// Verifica se o jogador foi pego pelo fantasma
if (jogador.getLinha() == fantasma.getLinha() && 
    jogador.getColuna() == fantasma.getColuna()) {



//Se o fantasma pegou o jogador
    lab.imprimirEstado(jogador, fantasma);
System.out.println("O fantasma te pegou, tente novamente...");
    jogoRodando = false;
    break; 
}            



// Verifica Comida na celula atual do jogador
Celula celulaJogador = lab.getCelula(jogador.getLinha(), jogador.getColuna());

    if (celulaJogador.isTemAlimento()) { 
    celulaJogador.setTemAlimento(false); 
    pontuacao++; // incrementa se tiver pego a comida 
 }



// Verifica se ganhou e comendo todos as comidas 
if (pontuacao == totalComidas) {
    lab.imprimirEstado(jogador, fantasma);
    System.out.println("PARABENS!!! VOCE GANHOU O JOGO");
    jogoRodando = false;
    break;
            }



// Move Fantasma, movendo depois do jogador) 
    fantasma.mover(0, lab); // ele escolhe sozinho



// Verifica se o fantasma pegou na mesma celula, ai acaba o jogo
if (jogador.getLinha() == fantasma.getLinha() && 
    jogador.getColuna() == fantasma.getColuna()) {


        
// Se o fantasma pegou o jogador
    lab.imprimirEstado(jogador, fantasma); // Mostra a colisão
    System.out.println("O Fantasma te pegou, tente novamente...");
    jogoRodando = false;
            }
        }

teclado.close();
    }
}