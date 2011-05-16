public class Tablero {

    private boolean humano;
    private boolean computador;
    private int cantidadTacos;

    public Tablero() {
        humano = false;
        computador = false;
        cantidadTacos = 0;
    }

    public boolean jugadorHumano() {
        return humano;
    }

    public boolean jugadorComputador() {
        return computador;
    }

    public void elegirJugador(int j) {
        if (j == 1) {
            humano = true;
        } else {
            computador = true;
        }
    }

    public int getCantidadTacos() {
        return cantidadTacos;
    }

    public void llenar() {
        cantidadTacos = 15;
    }

    public void quitarTaco(int posicion) {
        cantidadTacos--;
    }

    public boolean getPosicion(int pos) {
        return false;
    }
}
