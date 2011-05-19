
import java.util.ArrayList;

public class Tablero {

    private boolean humano;
    private boolean computador;
    private int cantidadTacos;
    private boolean[] listaTacos = new boolean[15];
    private ArrayList<String> listaComandos = new ArrayList<String>();

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
        listaTacos[posicion-1] = false;
        cantidadTacos--;
    }

    public boolean getPosicion(int posicion) {
        return listaTacos[posicion-1];
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

    //Comandos
    public boolean verificarComando(String comando) {
        String[] s = comando.split(" ");
        int pi = Integer.parseInt(s[0]) - 1;
        int pf = Integer.parseInt(s[2]) - 1;
        if (listaTacos[pi] && !listaTacos[pf]) { //Falta agregarle funcionalidad
            return saltar(pi, pf);
        } else {
            return false;
        }
    }

    public boolean saltar(int pi, int pf) {
        return true;
    }

    public void agregarComando(String comando) {
        if (verificarComando(comando)) {
            listaComandos.add(comando);
        } else {
            System.out.println("Comando invalido");
        }
    }

    public int getCantidadComandos() {
        return listaComandos.size();
    }
}
