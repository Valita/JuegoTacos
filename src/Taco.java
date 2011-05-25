
import java.util.ArrayList;

public class Taco {

    private String color;
    private boolean existe = false;
    private int posicion;
    private ArrayList<String> saltos = new ArrayList();

    public Taco() {
        existe = false;
        saltos.add("3,2/10,6");
        saltos.add("4,3/11,7");
        saltos.add("1,2/5,4/10,7/12,8");
        saltos.add("2,3/11,8");
        saltos.add("3,4/12,9");
        saltos.add("8,7/13,10");
        saltos.add("9,8/14,12");
        saltos.add("6,7/13,11");
        saltos.add("7,8/14,12");
        saltos.add("1,6/12,11/3,7");
        saltos.add("2,7/4,8");
        saltos.add("3,8/15,14/10,11");
        saltos.add("6,10/8,11");
        saltos.add("7,11/9,12");
        saltos.add("10,13/12,14");
    }

    public String obtenerColor() {
        return color;
    }

    public void definirColor(String _color) {
        color = _color;
    }

    public void definirExistencia(boolean _existe) {
        existe = _existe;
    }

    public boolean obtenerExistencia() {
        return existe;
    }

    public void definirPosicion(int pos) {
        posicion = pos;
    }

    public int obtenerPosicion() {
        return posicion;
    }

    public String obtenerSaltos() {
        return saltos.get(posicion - 1);
    }
}
