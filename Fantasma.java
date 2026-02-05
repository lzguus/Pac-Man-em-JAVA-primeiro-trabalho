import java.util.Random;

//classe do fantasma que herda da classe personagem e implementa a interface paredes
public class Fantasma extends Personagem implements Paredes { //Fantasma que herda da classe personagem e implementa a interface paredes



//construtor do personagem fantasma que chama o construtor da superclasse personagem
public Fantasma(int linhaInicio, int colunaInicio) {
    super(linhaInicio, colunaInicio, 'F');
    }



//Sobrescreve o metodo mover da interface paredes
    @Override


//mover o fantasma de forma aleatoria
public boolean mover(int direcao, Labirinto labirinto) {
    Random rand = new Random();
    int direcaoAleatoria = rand.nextInt(4); // Gera um numero entre 0 e 3 pra ele se mover, e dependendo do numero, tem a posicao pra ele se mover



// Pega a posiçao atual do fantasma
    int l = this.getLinha();
    int c = this.getColuna();



// Atualiza a nova posiçao conforme a direçao com o uso de switch
switch (direcaoAleatoria) {
    case 0:
        l--;
    break;
        case 1:
    l++;
        break;
    case 2:
        c--;
    break;
    case 3:
        c++;
        break;
        }


        
// Verifica se a nova posiçao é valida 
if (l >= 0 && l < labirinto.getQtdLinhas() && c >= 0 && c < labirinto.getQtdColunas()) {
    setPosicao(l, c);
    
// Se sim, retorna true, se nao, retorna false
    return true;
        } else {
    return false;
        }
    }
}