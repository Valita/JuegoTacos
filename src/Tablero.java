
import java.util.ArrayList;

public class Tablero {

    private static final int FIN_LINEA_CUATRO = 13;
    private static final int FIN_LINEA_TRES = 11;
    private static final int FIN_LINEA_DOS = 8;
    private static final int FIN_LINEA_UNO = 4;
    private int cantidadTacos;
    private ArrayList<Taco> listaTacos = new ArrayList<Taco>();

    public Tablero() {
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
            } else if (contadorAmarillo < 5 && randomico == 2) {
                listaTacos.get(i).definirColor("A");
                contadorAmarillo++;
            } else if (contadorBlanco < 5 && randomico == 3) {
                listaTacos.get(i).definirColor("B");
                contadorBlanco++;
            } else {
                i--;
            }
        }
        for (int i = 0; i < 15; i++) {
            if (listaTacos.get(i).obtenerColor() == null && contadorBlanco < 5) {
                listaTacos.get(i).definirColor("B");
                contadorBlanco++;
            }
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
        listaTacos.get(posicion).definirExistencia(false);
        cantidadTacos--;
    }

    public boolean getPosicion(int posicion) {
        return listaTacos.get(posicion).obtenerExistencia();
    }

    public String getColorTaco(int posicion) {
        return listaTacos.get(posicion).obtenerColor();
    }

    private String imprimirLetras(int cantidadPosiciones, int posInicial) {
        String imprimir = " ";
        for (int pos = posInicial; pos < cantidadPosiciones + posInicial; pos++) {
            if (this.getPosicion(pos)) {
                imprimir += this.getColorTaco(pos) + "  ";
            } else {
                imprimir += "0  ";
            }
        }
        imprimir += "\n";
        return imprimir;
    }

    private String imprimirPosiciones(int cantidadPosiciones, int posInicial) {
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

    public void saltar(int pInicial, int pFinal, int pMedio) {
        listaTacos.get(pFinal - 1).definirColor(getColorTaco(pInicial));
        quitarTaco(pInicial - 1);
        cantidadTacos++;
        listaTacos.get(pInicial - 1).definirColor("0");
        quitarTaco(pMedio - 1);
        listaTacos.get(pMedio - 1).definirColor("0");
        listaTacos.get(pFinal - 1).definirExistencia(true);
    }

    public String obtenerSaltos(int i) {
        return listaTacos.get(i).obtenerSaltos();
    }

    public boolean terminado() {
        for (Taco t : listaTacos) {
            if (t.obtenerExistencia()) {
                String[] jugada = t.obtenerSaltos().split("/");
                for (String s : jugada) {
                    String[] pos = s.split(" ");
                    int p = Integer.parseInt(pos[1]) - 1;
                    if (this.getPosicion(p)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int posicionVaciaAJugar() {
        ArrayList<Integer> vacios = new ArrayList<Integer>();
        int cantidadVacios=0;
        int elegible;
        int posicion=0;
        boolean existejugada = false;

        for (Taco vacio : listaTacos) {
            if (vacio.obtenerExistencia() == false) {
                vacios.add(vacio.obtenerPosicion());
                cantidadVacios++;
                existejugada = true;
            }
        }
        if (!existejugada) {
            return 0;
        }
        if (cantidadTacos != 14) {
            elegible = (int) (Math.random() * (cantidadVacios));
            posicion = vacios.get(elegible);
        }
        if(cantidadTacos == 14) {
            posicion = vacios.get(0);
        }
        return posicion;
    }
}
