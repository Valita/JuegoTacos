
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
            if (getPosicion(pos)) {
                
                    imprimir += getColorTaco(pos) + "  ";
                
            } else {
          
                    imprimir += "0  ";
                
            }
        }
        imprimir += "\n";
        return imprimir;
    }

    public String imprimirPosiciones(int cantidadPosiciones, int posInicial) {
        String imprimir = " ";
        for (int pos = posInicial; pos < cantidadPosiciones + posInicial; pos++) {
            if (pos < 10) {
                imprimir += pos + "  ";
            } else {
                imprimir += pos + " ";
            }
        }
        imprimir += "\n";
        return imprimir;
    }

    public String mostrar() {
        String cadenaTablero = "";
        cadenaTablero += imprimirLetras(5, 1);
        cadenaTablero += imprimirPosiciones(5, 1);
        cadenaTablero += " ";
        cadenaTablero += imprimirLetras(4, FIN_LINEA_UNO + 1);
        cadenaTablero += " ";
        cadenaTablero += imprimirPosiciones(4, FIN_LINEA_UNO + 2);
        cadenaTablero += "  ";
        cadenaTablero += imprimirLetras(3, FIN_LINEA_DOS + 1);
        cadenaTablero += "  ";
        cadenaTablero += imprimirPosiciones(3, FIN_LINEA_DOS + 2);
        cadenaTablero += "   ";
        cadenaTablero += imprimirLetras(2, FIN_LINEA_TRES + 1);
        cadenaTablero += "   ";
        cadenaTablero += imprimirPosiciones(2, FIN_LINEA_TRES + 2);
        cadenaTablero += "    ";
        cadenaTablero += imprimirLetras(1, FIN_LINEA_CUATRO + 1);
        cadenaTablero += "    ";
        cadenaTablero += imprimirPosiciones(1, FIN_LINEA_CUATRO + 2);
        return cadenaTablero;
    }

    public boolean agregarComando(String comando) {
        if (verificarEscrituraComando(comando)) {
            if (validarComando(comando)) {
                listaComandos.add(comando);
                return true;
            } else {
                System.out.println("Comando invalido");
                return false;
            }
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
        String[] s = comando.split(" ");
        int pInicialSalto = Integer.parseInt(s[0]) - 1;
        int pFinalSalto = Integer.parseInt(s[2]) - 1;
        int pMedioSalto;
        int mismaLinea;
        int cambio = 0;
        mismaLinea = pFinalSalto - pInicialSalto;
        if (mismaLinea == 2 || mismaLinea == -2) {
            pMedioSalto = (pInicialSalto + pFinalSalto) / 2;
        } else {
            pMedioSalto = (pInicialSalto + pFinalSalto) / 2 + 1;
        }
        if (listaTacos.get(pInicialSalto).obtenerExistencia() && !listaTacos.get(pFinalSalto).obtenerExistencia() && listaTacos.get(pMedioSalto).obtenerExistencia()) {
            if (pInicialSalto > pFinalSalto) {
                cambio = pFinalSalto;
                pFinalSalto = pInicialSalto;
                pInicialSalto = cambio;
            }
            if (mismaLinea == 2 || mismaLinea == -2) {
                if (cambio == 0) {
                    return saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                } else {
                    return saltar(pFinalSalto, pInicialSalto, pMedioSalto);
                }
            } else {
                if (pInicialSalto <= FIN_LINEA_UNO && pFinalSalto > FIN_LINEA_DOS && pFinalSalto <= FIN_LINEA_TRES) {
                    if (cambio == 0) {
                        return saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                    } else {
                        return saltar(pFinalSalto, pInicialSalto, pMedioSalto);
                    }
                }
                if (pInicialSalto <= FIN_LINEA_DOS && pFinalSalto > FIN_LINEA_TRES && pFinalSalto <= FIN_LINEA_CUATRO) {
                    if (cambio == 0) {
                        return saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                    } else {
                        return saltar(pFinalSalto, pInicialSalto, pMedioSalto);
                    }
                }
                if (pInicialSalto <= FIN_LINEA_TRES && pFinalSalto > FIN_LINEA_CUATRO) {
                    if (cambio == 0) {
                        return saltar(pInicialSalto, pFinalSalto, pMedioSalto);
                    } else {
                        return saltar(pFinalSalto, pInicialSalto, pMedioSalto);
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public int getCantidadComandos() {
        return listaComandos.size();
    }

    public boolean saltar(int pInicial, int pFinal, int pMedio) {
        listaTacos.get(pInicial).definirExistencia(false);
        listaTacos.get(pMedio).definirExistencia(false);
        listaTacos.get(pFinal).definirExistencia(true);
        listaTacos.get(pFinal).definirColor(listaTacos.get(pInicial).obtenerColor());
        cantidadTacos--;
        return true;
    }
}
