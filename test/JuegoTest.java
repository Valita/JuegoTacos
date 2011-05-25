
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    public JuegoTest() {
    }
    Juego jugada = new Juego();
    Tablero tablero;

    @Before
    public void llenarTablero() {
        tablero = jugada.getTablero();
    }

    @Test
    public void comenzandoElJuegoNoDeboTenerNingunJugadorDefinido() {
        assertFalse(jugada.jugadorHumano());
    }

    @Test
    public void alElegirUnJugadorElJuegoDebeSaberQueEseJugadorEstaSeleccionado() {
        jugada.elegirJugador("Computador");
        assertFalse(jugada.jugadorHumano());
        jugada.elegirJugador("Humano");
        assertTrue(jugada.jugadorHumano());
    }

    @Test
    public void sePuedeIngresarUnaJugada() {
        tablero.quitarTaco(3);
        assertTrue(jugada.agregarJugada("1 a 3"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEsValida() {
        tablero.quitarTaco(3);
        assertTrue(jugada.agregarJugada("1 a 3"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEsInvalida() {
        assertFalse(jugada.agregarJugada("1 a 1"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEstaEscritaCorrectamente() {
        assertFalse(jugada.agregarJugada("r a 12"));
    }

    @Test
    public void seDebeGuardarLasJugadasValidas() {
        tablero.quitarTaco(3);
        jugada.agregarJugada("1 a 3");
        assertEquals(1, jugada.getCantidadJugadas());
    }

    @Test
    public void siLaJugadaEsValidaSeDebeEjecutarElSaltoDelTaco() {
        jugada.elegirAgujero(4);
        System.out.println(tablero.mostrar());
        jugada.agregarJugada("11 a 4");
        System.out.println(tablero.mostrar());
        assertEquals(13, tablero.getCantidadTacos());
    }

    @Test
    public void unJugadorDebeSaberCuandoElJuegoATerminado() {
        for (int i = 0; i <= 11; i++) {
            tablero.quitarTaco(i);
        }
        tablero.quitarTaco(14);
        assertTrue(jugada.juegoTerminado());
    }

    @Test
    public void elJugadorPersonaDebePoderElegirDondeEstaraElAgujeroParaEmpezar() {
        jugada.elegirAgujero(3);
        assertFalse(tablero.getPosicion(2));
    }

    @Test
    public void elJugadorNoDebePoderElegirComoAgujeroParaEmpezarElJuegoNingunaEsquina() {
        assertFalse(jugada.elegirAgujero(1));
        assertFalse(jugada.elegirAgujero(5));
        assertFalse(jugada.elegirAgujero(15));
    }
}
