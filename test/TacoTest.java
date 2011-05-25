
import org.junit.Test;
import static org.junit.Assert.*;

public class TacoTest {

    Taco taco = new Taco();

    public TacoTest() {
    }

    @Test
    public void unTacoDebeTenerUnColor() {
        taco.definirColor("R");
        assertEquals("R", taco.obtenerColor());
    }

    @Test
    public void unTacoDebeSaberSiExisteEnElTablero() {
        taco.definirExistencia(true);
        assertTrue(taco.obtenerExistencia());
    }

    @Test
    public void unTacoDebePoseerUnaPosicion() {
        taco.definirPosicion(4);
        assertEquals(4, taco.obtenerPosicion());
    }

    @Test
    public void dependiendoDeSuPosicionElTacoDebeSaberADondePuedeSaltar() {
        taco.definirPosicion(1);
        assertEquals("3 2/10 6", taco.obtenerSaltos());
        taco.definirPosicion(2);
        assertEquals("4 3/11 7", taco.obtenerSaltos());
        taco.definirPosicion(3);
        assertEquals("1 2/5 4/10 7/12 8", taco.obtenerSaltos());
        taco.definirPosicion(4);
        assertEquals("2 3/11 8", taco.obtenerSaltos());
        taco.definirPosicion(5);
        assertEquals("3 4/12 9", taco.obtenerSaltos());
        taco.definirPosicion(6);
        assertEquals("8 7/13 10", taco.obtenerSaltos());
        taco.definirPosicion(7);
        assertEquals("9 8/14 12", taco.obtenerSaltos());
        taco.definirPosicion(8);
        assertEquals("6 7/13 11", taco.obtenerSaltos());
        taco.definirPosicion(9);
        assertEquals("7 8/14 12", taco.obtenerSaltos());
        taco.definirPosicion(10);
        assertEquals("1 6/12 11/3 7", taco.obtenerSaltos());
        taco.definirPosicion(11);
        assertEquals("2 7/4 8", taco.obtenerSaltos());
        taco.definirPosicion(12);
        assertEquals("3 8/15 14/10 11", taco.obtenerSaltos());
        taco.definirPosicion(13);
        assertEquals("6 10/8 11", taco.obtenerSaltos());
        taco.definirPosicion(14);
        assertEquals("7 11/9 12", taco.obtenerSaltos());
        taco.definirPosicion(15);
        assertEquals("10 13/12 14", taco.obtenerSaltos());
<<<<<<< HEAD

=======
>>>>>>> 4ef9b486cab6415e757477a4fb767a0e62168577
    }
}
