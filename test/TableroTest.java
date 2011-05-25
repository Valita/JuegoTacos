
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
        assertFalse(tablero.getExistenciaEnPosicion(3));
    }

    @Test
    public void seDebePoderMostrarElTableroLleno() {
        System.out.println(tablero.mostrar());
        assertNotSame("", tablero.mostrar());
        assertEquals(1, 1);
    }

    @Test
    public void siUnTacoExisteEnUnaPosicionDebeTenerUnColor() {
        if (tablero.getExistenciaEnPosicion(1)) {
            assertNotSame("", tablero.getColorTaco(1));
        }
    }
<<<<<<< HEAD

    @Test
    public void seDebeGuardarLosComandosValidos() {
        tablero.quitarTaco(3);
        tablero.agregarComando("1 a 3");
        assertEquals(1, tablero.getCantidadComandos());
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiLaJugadaEsValida() {
        tablero.quitarTaco(3);
        assertTrue(tablero.agregarComando("1 a 3"));
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiLaJugadaEsInvalida() {
        assertFalse(tablero.agregarComando("1 a 1"));
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiEstaEscritoCorrectamente() {
        assertFalse(tablero.agregarComando("r a 12"));
    }

    @Test
    public void siElComandoEsValidoSeDebeEjecutarElSaltoDelTaco() {
        System.out.println(tablero.mostrar());
        tablero.quitarTaco(4);
        tablero.agregarComando("11 a 4");
        System.out.println(tablero.mostrar());
        assertEquals(13, tablero.getCantidadTacos());

    }

    @Test
    public void elJugadorPersonaDebePoderElegirDondeEstaraElAgujeroParaEmpezar() {
        tablero.elegirAgujero(3);
        assertFalse(tablero.getExistenciaEnPosicion(3));
    }

    @Test
    public void elJugadorNoDebePoderElegirComoAgujeroParaEmpezarElJuegoNingunaEsquina() {
        assertFalse(tablero.elegirAgujero(1));
        assertFalse(tablero.elegirAgujero(5));
        assertFalse(tablero.elegirAgujero(15));
    }

    @Test
    public void unJugadorDebeSaberCuandoElJuegoATerminado() {
        for (int i = 1; i <= 12; i++) {
            tablero.quitarTaco(i);
        }
        tablero.quitarTaco(15);
        assertTrue(tablero.juegoTerminado());
    }

    @Test
    public void debeExistirAutomatizacionDeJugadasParaElJugadorComputador() {
        tablero.elegirAgujero(8);
        tablero.computadorJuega();
        assertTrue(tablero.juegoTerminado());
    }
=======
>>>>>>> 4ef9b486cab6415e757477a4fb767a0e62168577
}
