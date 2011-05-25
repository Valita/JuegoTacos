
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
        tablero.elegirJugador("Humano");
        assertTrue(tablero.jugadorHumano());
        tablero.elegirJugador("Computador");
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
        System.out.println(tablero.mostrar());
        assertNotSame("",tablero.mostrar());
        assertEquals(1,1);
    }

    @Test
    public void sePuedeIngresarUncomando(){
        tablero.quitarTaco(3);
        assertTrue(tablero.agregarComando("1 a 3"));
    }

    @Test
    public void siUnTacoExisteEnUnaPosicionDebeTenerUnColor()
    {
        if(tablero.getPosicion(1)) assertNotSame("",tablero.getColorTaco(1));
    }

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
    public void siSeIngresaUnComandoVerificarSiLaJugadaEsInvalida(){
        assertFalse(tablero.agregarComando("1 a 1"));
    }

    @Test
    public void siSeIngresaUnComandoVerificarSiEstaEscritoCorrectamente() {
        assertFalse(tablero.agregarComando("r a 12"));
    }

    @Test
    public void siElComandoEsValidoSeDebeEjecutarElSaltoDelTaco() {
        System.out.println(tablero.mostrar());
        tablero.quitarTaco(3);
        tablero.agregarComando("12 a 3");
        System.out.println(tablero.mostrar());
        assertEquals(13,tablero.getCantidadTacos());

    }
    
}