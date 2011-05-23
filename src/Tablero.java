
import java.util.ArrayList;

public class Tablero {

    private static final int FIN_LINEA_CUATRO = 13;
    private static final int FIN_LINEA_TRES = 11;
    private static final int FIN_LINEA_DOS = 8;
    private static final int FIN_LINEA_UNO = 4;
    private boolean humano;
    private boolean computador;
    private int cantidadTacos;
    private Taco[] listaTacos = new Taco[15];
    private ArrayList<String> listaComandos = new ArrayList<String>();

    public Tablero() {


        humano = false;
        computador = false;
        cantidadTacos = 0;

    }

    private void colorearTacos()
    {
        int contadorRojo = 0;
        int contadorAmarillo = 0;
        int contadorBlanco = 0;
        int randomico;

        for (int i = 0; i < 9; i++) {
            randomico = (int) (Math.random() * 15);
            if (listaTacos[randomico].obtenerColor() != null) {
                if (contadorAmarillo < 4) {
                    listaTacos[i].definirColor("A");
                    contadorAmarillo++;
                }
                else{
                    listaTacos[i].definirColor("R");
                    contadorRojo++;
                }
            }
            else
            {
                i--;
            }
        }
        for(int i = 0 ; i <15 ; i++)
        {
            if(listaTacos[i].obtenerColor() == null && contadorBlanco <5)
            {
                listaTacos[i].definirColor("B");
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

    public void llenarTablero() {
        for (int i = 0; i < 15; i++) {
            listaTacos[i].definirExistencia(true);
        }
        colorearTacos();
        cantidadTacos = 15;
    }

    public void quitarTaco(int posicion) {
        listaTacos[posicion - 1].definirExistencia(false);
        cantidadTacos--;
    }

    public boolean getPosicion(int posicion) {
        return listaTacos[posicion - 1].obtenerExistencia();
    }

    public String mostrar() {
        String cadenaTablero = "";
        int cont = 0;
        if (cantidadTacos > 0) {
            for (int posicion = 0; posicion < 15; posicion++) {
                if (listaTacos[posicion].obtenerExistencia() == true) {
                    if (posicion < 9) {
                        cadenaTablero += " " + String.valueOf(posicion + 1);
                    } else {
                        cadenaTablero += String.valueOf(posicion + 1);
                    }
                } else {
                    cadenaTablero += "  ";
                }
                cadenaTablero += "  ";
                if (posicion == FIN_LINEA_UNO || posicion == FIN_LINEA_DOS || posicion == FIN_LINEA_TRES || posicion == FIN_LINEA_CUATRO) {
                    cadenaTablero += "\n";
                    cont++;
                    for (int j = 0; j < cont; j++) {
                        cadenaTablero += "  ";
                    }
                }
            }
        }
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

    private boolean validarComando(String comando) {
        String[] s = comando.split(" ");
        int pInicialSalto = Integer.parseInt(s[0]) - 1;
        int pFinalSalto = Integer.parseInt(s[2]) - 1;
        int pMedioSalto = (pInicialSalto + pFinalSalto) / 2;
        if (listaTacos[pInicialSalto].obtenerExistencia() && !listaTacos[pFinalSalto].obtenerExistencia() && listaTacos[pMedioSalto].obtenerExistencia()) {
            return saltar(pInicialSalto, pFinalSalto, pMedioSalto);
        } else {
            return false;
        }
    }

    public int getCantidadComandos() {
        return listaComandos.size();
    }

    public boolean saltar(int pInicial, int pFinal, int pMedio) {
        listaTacos[pInicial].definirExistencia(false);
        listaTacos[pMedio].definirExistencia(false);
        listaTacos[pFinal].definirExistencia(true);
        listaTacos[pFinal].definirColor(listaTacos[pInicial].obtenerColor());
        cantidadTacos--;
        return true;
    }
}
