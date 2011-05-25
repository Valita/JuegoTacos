
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TableroTest {

    public TableroTest() {
    }
    Tablero tablero = new Tablero();

    @Before
    public void llenarTablero() {
        tablero.llenarTablero();
    }

    @Test
    public void alCrearUnTableroDebeEstarVacio() {
        Tablero tableroVacio = new Tablero();
        assertEquals(0, tableroVacio.getCantidadTacos());
    }

    @Test
    public void alComenzarElJuegoElTableroDebeEstarLleno() {
        assertEquals(15, tablero.getCantidadTacos());
    }

    @Test
    public void siSeQuitaUnTacoLaCantidadDeTacosDebeDisminuir() {
        tablero.quitarTaco(3);
        assertEquals(14, tablero.getCantidadTacos());
    }

    @Test
    public void siSeQuitaUnTacoDeUnaPosicionEsaPosicionDebeQuedarVacia() {
        tablero.quitarTaco(3);
        assertFalse(tablero.getPosicion(3));
    }

    @Test
    public void seDebePoderMostrarElTableroLleno() {
        System.out.println(tablero.mostrar());
        assertNotSame("", tablero.mostrar());
        assertEquals(1, 1);
    }

    @Test
    public void siUnTacoExisteEnUnaPosicionDebeTenerUnColor() {
        if (tablero.getPosicion(1)) {
            assertNotSame("", tablero.getColorTaco(1));
        }
    }

    @Test
    public void elJugadorPersonaDebePoderElegirDondeEstaraElAgujeroParaEmpezar() {
        tablero.elegirAgujero(3);
        assertFalse(tablero.getPosicion(3));
    }

    @Test
    public void elJugadorNoDebePoderElegirComoAgujeroParaEmpezarElJuegoNingunaEsquina() {
        assertFalse(tablero.elegirAgujero(1));
        assertFalse(tablero.elegirAgujero(5));
        assertFalse(tablero.elegirAgujero(15));
    }
}
