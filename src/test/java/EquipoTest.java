import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EquipoTest {

    private Equipo equipo;

    @Test
    public void despedirJugadorTest(){
        Equipo equipo = new Equipo("Nacional");
        JugadorEnum jugador1 = new JugadorEnum("Pedro", 500000, 3.7f, 18, Posicion.DEF, LocalDate.of(2020, 9, 14));
        JugadorEnum jugador2 = new JugadorEnum("Samuel", 450000, 4.6f, 10, Posicion.DEL, LocalDate.of(2019, 4, 30));
        JugadorEnum jugador3 = new JugadorEnum("Jaime", 670000, 2.9f, 20, Posicion.MED, LocalDate.of(2021, 12, 18));

        ArrayList<JugadorEnum> jugadoresDespedidos = equipo.despedirJugador(jugador3);

        assertEquals(1, jugadoresDespedidos.size());
        assertEquals(jugador3, jugadoresDespedidos.get(0));
    }
}
