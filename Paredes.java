public interface Paredes {
// Direcoes das paredes, com os numeros pra facilitar a leitura e nao confundir
    public static final int CIMA = 1;
    public static final int BAIXO = 2;
    public static final int ESQUERDA = 3;
    public static final int DIREITA = 4;

// Metodo mover que sera implementado pelas classes que implementarem essa interface com a direcao e o labirinto como parametros
    public boolean mover(int direcao, Labirinto labirinto);
}