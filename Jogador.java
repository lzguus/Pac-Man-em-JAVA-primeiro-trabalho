public class Jogador extends Personagem implements Paredes { //Jogador que herda da classe personagem e implementa a interface paredes

  // Direcoes das paredes com os numeros pra facilitar a leitura
  public static final int CIMA = 0;
  public static final int BAIXO = 1;
  public static final int ESQUERDA = 2;
  public static final int DIREITA = 3;

  public Jogador () {
    super(0, 0, 'J');
  }

  //Sobrescreve o metodo mover da interface paredes
  @Override


  //Move o jogador conforme a direçao escolhida
    public boolean mover(int direcao, Labirinto labirinto) {

// Pega a posiçao atual do jogador
        int linhaAtual = this.getLinha();
        int colunaAtual = this.getColuna();

// Calcula a nova posiçao do jogador com a direçao escolhida  
        int novaLinha = linhaAtual;
        int novaColuna = colunaAtual;



// Atualiza a nova posiçao conforme a direçao escolhida   
if (direcao == Paredes.CIMA) {
    novaLinha--; 
        } 
else if (direcao == Paredes.BAIXO) {
    novaLinha++; 
        } 
else if (direcao == Paredes.ESQUERDA) {
    novaColuna--; 
        } 
else if (direcao == Paredes.DIREITA) {
    novaColuna++; 
        }


// Verifica se a nova posiçao é valida
Celula celulaAtual = labirinto.getCelula(linhaAtual, colunaAtual);
boolean podeMover = false;




// Verifica se tem parede na direçao escolhida, ou se ta bloqueada a passagem
if (direcao == Paredes.CIMA && !celulaAtual.isParedeCima()) {
    podeMover = true;
        } 
else if (direcao == Paredes.BAIXO && !celulaAtual.isParedeBaixo()) {
    podeMover = true;
        } 
else if (direcao == Paredes.ESQUERDA && !celulaAtual.isParedeEsquerda()) {
    podeMover = true;
        } 
else if (direcao == Paredes.DIREITA && !celulaAtual.isParedeDireita()) {
    podeMover = true;
  } else {




// Se tiver parede, nao pode mover   
    return false; 
  }


  

// Move o jogador se puder 
        if (podeMover) {
            setPosicao(novaLinha, novaColuna);
        }

        return podeMover;
    }
  }