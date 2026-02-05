public abstract class Personagem {
//Atributos do personagem
    private int linha;
    private int coluna;
    private char simbolo;


//construtor do personagem com linha, coluna e simbolo de cada
    public Personagem(int linha, int coluna, char simbolo) {


//inicializa os atributos do personagem com as posicoes e simbolo 
        this.linha = linha;
        this.coluna = coluna;
        this.simbolo = simbolo;
    }


//Usado para setar a posiçao do personagem na nova posicao
    public void setPosicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }


//para mover o personagem na direçao desejada
    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getColuna() {
        return coluna;
    }
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public char getSimbolo() {
        return simbolo;
    }
    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

}