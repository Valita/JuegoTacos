/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scout
 */
public class Taco {
    private String color;
    private boolean existe = false;

    public Taco()
    {
        existe = false;
    }

    public String obtenerColor()
    {
        return color;
    }

    public void definirColor(String _color)
    {
        color = _color;
    }

    public void definirExistencia(boolean _existe)
    {
        existe = _existe;
    }

    public boolean obtenerExistencia()
    {
        return existe;
    }
}
