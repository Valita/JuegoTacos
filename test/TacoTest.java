
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
}
