
import java.util.ArrayList;

public class Tablero {

    private static final int ULTIMA_LINEA = 14;
    private static final int FIN_LINEA_CUATRO = 13;
    private static final int FIN_LINEA_TRES = 11;
    private static final int FIN_LINEA_DOS = 8;
    private static final int FIN_LINEA_UNO = 4;
    private boolean humano;
    private boolean computador;
    private int cantidadTacos;
    private ArrayList<Taco> listaTacos = new ArrayList<Taco>();
    private ArrayList<String> listaComandos = new ArrayList<String>();

    public Tablero() {


        humano = false;
        computador = false;
        cantidadTacos = 0;

    }

    private void colorearTacos() {
        int contadorRojo = 0;
        int contadorAmarillo = 0;
        int contadorBlanco = 0;
        int randomico;

        for (int i = 0; i < 15; i++) {
            randomico = (int) (Math.random() * 4);
            if (contadorRojo < 5 && randomico == 1) {
                listaTacos.get(i).definirColor("R");
                contadorRojo++;
            } else {
                if (contadorAmarillo < 5 && randomico == 2) {
                    listaTacos.get(i).definirColor("A");
                    contadorAmarillo++;
                } else {
                    if (contadorBlanco < 5 && randomico == 3) {
                        listaTacos.get(i).definirColor("B");
                        contadorBlanco++;
                    } else {
                        i--;
                    }
                }
            }
        }
        for (int i = 0; i < 15; i++) {
            if (listaTacos.get(i).obtenerColor() == null && contadorBlanco < 5) {
                listaTacos.get(i).definirColor("B");
                contadorBlanco++;
            }
        }
    }

    public boolean jugadorHumano() {
        return humano;
    }

    public boolean jugadorComputador() {
        return computador;
    }

    public void elegirJugador(String jugador) {
        if (jugador.equalsIgnoreCase("Humano")) {
            humano = true;
        } else {
            computador = true;
        }
    }

    public int getCantidadTacos() {
        return cantidadTacos;
    }

    public void llenarTablero() {
        for (int i = 0; i < 15; i++) {

            listaTacos.add(new Taco());
            listaTacos.get(i).definirExistencia(true);
            listaTacos.get(i).definirPosicion(i + 1);
        }
        colorearTacos();
        cantidadTacos = 15;
    }

    public void quitarTaco(int posicion) {
        listaTacos.get(posicion - 1).definirExistencia(false);
        cantidadTacos--;
    }

    public boolean getPosicion(int posicion) {
        return listaTacos.get(posicion - 1).obtenerExistencia();
    }

    public String getColorTaco(int posicion) {
        return listaTacos.get(posicion - 1).obtenerColor();
    }

    public String imprimirLetras(int cantidadPosiciones, int posInicial) {
        String imprimir = " ";
        for (int pos = posInicial; pos < cantidadPosiciones + posInicial; pos++) {
            imprimir += getColorTaco(pos + 1) + "  ";
        }
        imprimir += "\n";
        return imprimir;
    }

    public String imprimirPosiciones(int cantidadPosiciones, int posInicial) {
        String imprimir = " ";
        for (int pos = posInicial; pos < cantidadPosiciones + posInicial; pos++) {
            imprimir += listaTacos.get(pos).obtenerPosicion();
            if (pos < 9) {
                imprimir += "  ";
            } else {
                imprimir += " ";
            }
        }
        imprimir += "\n";
        return imprimir;
    }

    public String mostrar() {
        String cadenaTablero = "";
        cadenaTablero += imprimirLetras(5, 0);
        cadenaTablero += imprimirPosiciones(5, 0);
        cadenaTablero += " ";
        cadenaTablero += imprimirLetras(4, FIN_LINEA_UNO + 1);
        cadenaTablero += " ";
        cadenaTablero += imprimirPosiciones(4, FIN_LINEA_UNO + 1);
        cadenaTablero += "  ";
        cadenaTablero += imprimirLetras(3, FIN_LINEA_DOS + 1);
        cadenaTablero += "  ";
        cadenaTablero += imprimirPosiciones(3, FIN_LINEA_DOS + 1);
        cadenaTablero += "   ";
        cadenaTablero += imprimirLetras(2, FIN_LINEA_TRES + 1);
        cadenaTablero += "   ";
        cadenaTablero += imprimirPosiciones(2, FIN_LINEA_TRES + 1);
        cadenaTablero += "    ";
        cadenaTablero += imprimirLetras(1, FIN_LINEA_CUATRO + 1);
        cadenaTablero += "    ";
        cadenaTablero += imprimirPosiciones(1, FIN_LINEA_CUATRO + 1);
        return cadenaTablero;
    }

    public boolean agregarComando(String comando) {

        if (validarComando(comando)) {
            listaComandos.add(comando);
            return true;
        } else {
            System.out.println("Comando invalido");
            return false;
        }
    }

    private boolean verificarEscrituraComando(String comando) {
        boolean parteUno = false;
        boolean parteDos = false;
        String[] entrada = comando.split(" ");
        if (entrada.length != 3) {
            return false;
        }
        if (!entrada[1].equals("a")) {
            return false;
        }
        for (int num = 1; num < 16; num++) {
            if (entrada[0].equals(String.valueOf(num))) {
                parteUno = true;
            }
            if (entrada[2].equals(String.valueOf(num))) {
                parteDos = true;
            }
        }
        if (parteDos && parteUno) {
            return true;
        } else {
            return false;
        }
    }

    private boolean validarComando(String comando) {
        if (verificarEscrituraComando(comando)) {
            String[] jugada;

            int pInicialSalto = primerCaracter(comando);
            int pFinalSalto = tercerCaracter(comando);
            int pMedioSalto;

            String saltosPosibles = listaTacos.get(pInicialSalto - 1).obtenerSaltos();
            jugada = saltosPosibles.split("/");
            for (String s : jugada) {
                if (pFinalSalto == primerCaracter(s)) {
                    pMedioSalto = segundoCaracter(s);
                    saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                    return true;
                }
            }
            return false;

        } else {
            return false;
        }
    }

    private int primerCaracter(String comando) {
        String[] jugada = comando.split(" ");
        return Integer.parseInt(jugada[0]);
    }

    private int tercerCaracter(String comando) {
        String[] jugada = comando.split(" ");
        return Integer.parseInt(jugada[2]);
    }

    private int segundoCaracter(String comando) {
        String[] jugada = comando.split(" ");
        return Integer.parseInt(jugada[1]);
    }

    public int getCantidadComandos() {
        return listaComandos.size();
    }

    public boolean saltar(int pInicial, int pFinal, int pMedio) {
        listaTacos.get(pFinal - 1).definirColor(getColorTaco(pInicial));
        quitarTaco(pInicial);
        cantidadTacos++;
        listaTacos.get(pInicial - 1).definirColor("0");
        quitarTaco(pMedio);
        listaTacos.get(pMedio - 1).definirColor("0");
        listaTacos.get(pFinal - 1).definirExistencia(true);
        return true;
    }

    public boolean elegirAgujero(int pos) {
        if (validarPosicionAgujero(pos)) {
            quitarTaco(pos);
            return true;
        } else {
            return false;
        }
    }

    public boolean validarPosicionAgujero(int pos) {
        if (pos != 1 && pos != 5 && pos != 15) {
            return true;
        } else {
            return false;
        }
    }

    public boolean juegoTerminado() {
        boolean terminado = true;
        if (cantidadTacos == 1) {
            return true;
        }
        if (cantidadTacos <= 4) {
            for(Taco t:listaTacos){
                if(t.obtenerExistencia()){
                    String[] jugada = t.obtenerSaltos().split("/");
                    for(String s:jugada){
                        if(getPosicion(segundoCaracter(s))) terminado = false;
                    }
                }
            }
            return terminado;
        } else {
            return false;
        }
    }
}
