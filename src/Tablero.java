
public class Tablero {

    private boolean humano;
    private boolean computador;
    private int cantidadTacos;
    private boolean[] listaTacos = new boolean[15];

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
        for (int i = 0; i < 15; i++) {
            listaTacos[i] = true;
        }
        cantidadTacos = 15;
    }

    public void quitarTaco(int posicion) {
        listaTacos[posicion] = false;
        cantidadTacos--;
    }

    public boolean getPosicion(int pos) {
        return false;
    }

    public boolean mostrar() {
        int cont = 0;
        for (int i = 0; i < 15; i++) {
            if (listaTacos[i] == true) {
                System.out.print('*');
            }
            System.out.print(" ");
            if (i == 4 || i == 8 || i == 11 || i == 13) {
                System.out.println();
                cont++;
                for (int j = 0; j < cont; j++) {
                    System.out.print(" ");
                }
            }
        }
        return true;
    }
}
