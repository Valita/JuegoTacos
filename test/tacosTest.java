
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
        assertTrue(tablero.mostrar());
    }

    //Comandos
    @Test
    public void siSeIngresaUnComandoVerificarSiEsValido() {
        tablero.quitarTaco(3);
        assertTrue(tablero.verificarComando("1 a 3"));
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiEsInvalido() {
        assertFalse(tablero.verificarComando("1 a 1"));
    }

    @Test
    public void seDebeRealizarUnSaltoSiElComandoEsValido() {
        assertTrue(tablero.saltar(1, 3));
    }

//    @Test
//    public void seDebeVerificarQueLaPosicionFinalDelComandoEstaDisponible() {
//    }
    @Test
    public void seDebeGuardarLosComandosValidos() {
        tablero.quitarTaco(3);
        tablero.agregarComando("1 a 3");
        assertEquals(1, tablero.getCantidadComandos());
    }
}
