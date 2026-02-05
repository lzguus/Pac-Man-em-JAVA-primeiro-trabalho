public class Celula {
    
// Atributos da celula do labirinto
private int linha;
private int coluna;


// Paredes da celula do labirinto
private boolean paredeCima;
private boolean paredeBaixo;
private boolean paredeEsquerda;
private boolean paredeDireita;

// Se a celula ja foi visitada no processo de gerar o labirinto
private boolean visitada;
private boolean comida;

//Construtor da celula do labirinto
public Celula(int linha, int coluna) {

//inicializa a celula com todas as paredes
    this.linha = linha;
    this.coluna = coluna;


// Todas as paredes estao aparecendo inicialmente com o true
    this.paredeCima = true;
    this.paredeBaixo = true;
    this.paredeEsquerda = true;
    this.paredeDireita = true;


// A celula nao foi visitada ainda e tem comida inicialmente
    this.visitada = false;
    this.comida = true;
}


// Getters e Setters dos atributos da celula
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

public boolean isParedeCima() {
    return paredeCima;
}

public void setParedeCima(boolean paredeCima) {
    this.paredeCima = paredeCima;
}

public boolean isParedeBaixo() {
    return paredeBaixo;
}

public void setParedeBaixo(boolean paredeBaixo) {
    this.paredeBaixo = paredeBaixo;
}

public boolean isParedeEsquerda() {
    return paredeEsquerda;
}

public void setParedeEsquerda(boolean paredeEsquerda) {
    this.paredeEsquerda = paredeEsquerda;
}

public boolean isParedeDireita() {
    return paredeDireita;
}

public void setParedeDireita(boolean paredeDireita) {
    this.paredeDireita = paredeDireita;
}

public boolean isVisitada() {
    return visitada;
}

public void setVisitada(boolean visitada) {
    this.visitada = visitada;
}

public boolean isComida() {
    return comida;
}

public void setComida(boolean comida) {
    this.comida = comida;


}
public boolean isTemAlimento() {
    return this.comida;
    }

public void setTemAlimento(boolean valor) {
    this.comida = valor;
    }
}
