
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
        String cadenaAComparar= " 1   2   3   4   5  \n   6   7   8   9  \n    10  11  12  \n      13  14  \n        15  ";
        System.out.println(tablero.mostrar());
        assertEquals(cadenaAComparar,tablero.mostrar());
    }

    @Test
    public void sePuedeIngresarUncomando(){
        tablero.quitarTaco(3);
        assertTrue(tablero.agregarComando("1 a 3"));
    }

    @Test
    public void seDebeGuardarLosComandosValidos() {
        tablero.quitarTaco(3);
        tablero.agregarComando("1 a 3");
        assertEquals(1, tablero.getCantidadComandos());
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiEsValido() {
        tablero.quitarTaco(3);
        assertTrue(tablero.agregarComando("1 a 3"));
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiEsInvalido() {
        assertFalse(tablero.agregarComando("1 a 1"));
    }

    @Test
    public void siElComandoEsValidoSeDebeEjecutarElSaltoDelTaco() {
        tablero.quitarTaco(3);
        tablero.agregarComando("5 a 3");
        tablero.mostrar();
        assertEquals(13,tablero.getCantidadTacos());
    }

    
}
