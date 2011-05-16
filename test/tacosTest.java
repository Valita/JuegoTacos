
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class tacosTest {

    public tacosTest() {
    }
    Tablero tablero = new Tablero();

    @Before
    public void llenarTablero() {
        tablero.llenar();
    }

    @Test
    public void comenzandoElJuegoNoDeboTenerNingunJugadorDefinido() {
        assertFalse(tablero.jugadorComputador());
        assertFalse(tablero.jugadorHumano());
    }

    @Test
    public void alElegirUnJugadorElTableroDebeSaberQueEseJugadorEstaSeleccionado() {
        tablero.elegirJugador(1);
        assertTrue(tablero.jugadorHumano());
        tablero.elegirJugador(2);
        assertTrue(tablero.jugadorComputador());
    }

    @Test
    public void alCrearUntableroDebeEstarVacio() {
        Tablero tableroVacio = new Tablero();
        assertEquals(0, tableroVacio.getCantidadTacos());
    }

    @Test
    public void alComenzarElJuegoElTableroDebeEstarLleno() {

        assertEquals(15, tablero.getCantidadTacos());
    }

    @Test
    public void siSeQuitaUnTacoLaCantidadDeTacosDebeDisminuir() {
        tablero.quitarTaco(1);
        assertEquals(14, tablero.getCantidadTacos());
    }

    @Test
    public void siSeQuitaUnTacoDeUnaPosicionEsaPosicionDebeQuedarVacia() {
        tablero.quitarTaco(1);
        assertFalse(tablero.getPosicion(1));
    }
}
