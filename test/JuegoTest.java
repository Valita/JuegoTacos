
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JuegoTest {

    public JuegoTest() {
    }
    Juego juego = new Juego();
    Tablero tablero;

    @Before
    public void llenarTablero() {
        tablero = juego.getTablero();
    }

    @Test
    public void comenzandoElJuegoNoDeboTenerNingunJugadorDefinido() {
        assertFalse(juego.jugadorHumano());
    }

    @Test
    public void alElegirUnJugadorElJuegoDebeSaberQueEseJugadorEstaSeleccionado() {
        juego.elegirJugador("Computador");
        assertFalse(juego.jugadorHumano());
        juego.elegirJugador("Humano");
        assertTrue(juego.jugadorHumano());
    }

    @Test
    public void sePuedeIngresarUnaJugada() {
        tablero.quitarTaco(3);
        assertTrue(juego.agregarJugada("1 a 3"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEsValida() {
        tablero.quitarTaco(3);
        assertTrue(juego.agregarJugada("1 a 3"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEsInvalida() {
        assertFalse(juego.agregarJugada("1 a 1"));
    }

    @Test
    public void siSeIngresaUnaJugadaVerificarSiEstaEscritaCorrectamente() {
        assertFalse(juego.agregarJugada("r a 12"));
    }

    @Test
    public void seDebeGuardarLasJugadasValidas() {
        tablero.quitarTaco(3);
        juego.agregarJugada("1 a 3");
        assertEquals(1, juego.getCantidadJugadas());
    }

    @Test
    public void siLaJugadaEsValidaSeDebeEjecutarElSaltoDelTaco() {
        juego.elegirAgujero(4);
        System.out.println(tablero.mostrar());
        juego.agregarJugada("11 a 4");
        System.out.println(tablero.mostrar());
        assertEquals(13, tablero.getCantidadTacos());
    }

    @Test
    public void unJugadorDebeSaberCuandoElJuegoATerminado() {
        for (int i = 0; i <= 11; i++) {
            tablero.quitarTaco(i);
        }
        tablero.quitarTaco(14);
        assertTrue(juego.juegoTerminado());
    }

    @Test
    public void elJugadorPersonaDebePoderElegirDondeEstaraElAgujeroParaEmpezar() {
        juego.elegirAgujero(3);
        assertFalse(tablero.getPosicion(2));
    }

    @Test
    public void elJugadorNoDebePoderElegirComoAgujeroParaEmpezarElJuegoNingunaEsquina() {
        assertFalse(juego.elegirAgujero(1));
        assertFalse(juego.elegirAgujero(5));
        assertFalse(juego.elegirAgujero(15));
    }

    @Test
    public void debeExistirAutomatizacionDeJugadasParaElJugadorComputador() {
        juego.elegirAgujero(8);
        juego.computadorJuega();
        assertTrue(juego.juegoTerminado());
    }
}
