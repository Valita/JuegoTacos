
import java.util.ArrayList;

public class Juego {

    private boolean humano;
    private ArrayList<String> listaJugadas = new ArrayList<String>();
    private Tablero tablero;

    Juego() {
        tablero = new Tablero();
        tablero.llenarTablero();
        humano = false;
    }

    public boolean jugadorHumano() {
        return humano;
    }

    public void elegirJugador(String jugador) {
        if (jugador.equalsIgnoreCase("Humano")) {
            humano = true;
        }
    }

    public boolean agregarJugada(String jugada) {
        if (validarJugada(jugada)) {
            listaJugadas.add(jugada);
            return true;
        } else {
            System.out.println("Comando invalido");
            return false;
        }
    }

    private boolean validarJugada(String j) {
        if (verificarEscrituraJugada(j)) {
            String[] jugada;

            int pInicialSalto = primerCaracter(j);
            int pFinalSalto = tercerCaracter(j);
            int pMedioSalto;

            String saltosPosibles = tablero.obtenerSaltos(pInicialSalto - 1);
            jugada = saltosPosibles.split("/");
            for (String s : jugada) {
                if (pFinalSalto == primerCaracter(s)) {
                    pMedioSalto = segundoCaracter(s);
                    tablero.saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                    return true;
                }
            }
        }
        return false;
    }

    private int primerCaracter(String j) {
        String[] jugada = j.split(" ");
        return Integer.parseInt(jugada[0]);
    }

    private int tercerCaracter(String j) {
        String[] jugada = j.split(" ");
        return Integer.parseInt(jugada[2]);
    }

    private int segundoCaracter(String j) {
        String[] jugada = j.split(" ");
        return Integer.parseInt(jugada[1]);
    }

    private boolean verificarEscrituraJugada(String jugada) {
        int parteUno;
        int parteDos;
        String[] entrada = jugada.split(" ");
        if (entrada.length != 3) {
            return false;
        }
        if (!entrada[1].equals("a")) {
            return false;
        }

        try {
            parteUno = Integer.parseInt(entrada[0]);
            parteDos = Integer.parseInt(entrada[2]);
            return (parteUno > 0 && parteDos > 0 && parteUno < 16 && parteDos < 16);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getCantidadJugadas() {
        return listaJugadas.size();
    }

    Tablero getTablero() {
        return tablero;
    }

    public boolean juegoTerminado() {
        if (tablero.getCantidadTacos() == 1) {
            return true;
        }
        if (tablero.getCantidadTacos() <= 4) {
            return tablero.terminado();
        } else {
            return false;
        }
    }
}
