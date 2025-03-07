import java.util.ArrayList;
import java.util.List;

public class Equipo {
    String nombre;
    float salarioTotal;
    ArrayList<Jugador> jugadores;
    int cantidadDisponible = 200;
    ArrayList<JugadorBase> jugador;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.salarioTotal = salarioTotal;
        this.jugadores = new ArrayList<Jugador>();
        this.jugador = new ArrayList<JugadorBase>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(float salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<JugadorBase> getJugador() {
        return jugador;
    }

    public void setJugador(ArrayList<JugadorBase> jugador) {
        this.jugador = jugador;
    }

    /**
     * metodo para despedir un jugador
     * @param jugador
     * @return
     * @throws Exception
     */
    public ArrayList<Jugador> despedirJugador(Jugador jugador) throws Exception{
        ArrayList <Jugador> jugadoresDespedidos = new ArrayList<Jugador>();
        if(jugador.getCalificacion() <= 3){
            if(jugadores.remove(jugador)) {
                jugadoresDespedidos.add(jugador);
            }
        }
        return jugadoresDespedidos;
    }

    /**
     * metodo para verificar si un jugador es necesario
     * @param jugador
     * @return
     */
    public boolean esNecesario(Jugador jugador){
        if(jugador.getCalificacion() >= 4){
            return true;
        }
        return false;
    }

    /**
     * metodo para obtener el peor jugador
     * @param jugadores
     * @return
     */
    public Jugador obtenerPeorJugador(ArrayList<Jugador> jugadores){
        Jugador peorJugador = jugadores.get(0);
        for(int i = 1; i < jugadores.size(); i++){
            if(jugadores.get(i).getCalificacion() < peorJugador.getCalificacion()){
                peorJugador = jugadores.get(i);
            }
        }
        return peorJugador;
    }

    /**
     * metodo para contratar un jugador
     * @param jugador
     */
    public void contratarJugador (Jugador jugador) {

        if (esNecesario(jugador) && jugador.getSalario() < cantidadDisponible) {
            jugadores.add(jugador);
        }else if(!jugadores.isEmpty()){

            Jugador peorJugador = obtenerPeorJugador(jugadores);

            if(jugador.getPosJuego().equals(peorJugador.getPosJuego()) && jugador.getCalificacion() > peorJugador.getCalificacion()){
                if(jugadores.remove(peorJugador)){
                    jugadores.add(jugador);
                }
            }
        }
    }

    /**
     * metodo para generar el numero aleatorio de la camiseta de un jugador
     * @return
     */
    private String generarNumeroCamiseta() {
        String numero = "";
        for (int i = 0; i < 10; i++) {
            numero += "" + ((int) (Math.random() * 10));
        }
        return numero;
    }

    /**
     * metodo para calcular el salario de cada jugador
     */
    public float calcularSalarioTotal() {
        float total = 0;
        for (JugadorBase jugador : jugador) {
            total += jugador.getSalario();
        }
        return total;
    }
    public List<Float> calcularPorcentajeSalariosPorPosicion() throws Exception {
        if (jugadores.isEmpty()) {
            throw new Exception("el equipo no tiene jugadores registrados.");
        }

        if (salarioTotal == 0) {
            throw new Exception("el salario total del equipo es 0, no se pueden calcular los porcentajes.");
        }

        List<Float> porcentajes = new ArrayList<>();
        for (JugadorBase jugador : jugador) {
            porcentajes.add(jugador.calcularPorcentaje(salarioTotal));
        }

        return porcentajes;
    }

    public void rebajarSueldoJugador(Jugador jugador){
        if(jugador.calcularAntiguedad() > 2 && jugador.getCalificacion() > 3 && jugador.getCalificacion()< 5) {
            float nuevoSalario = jugador.getSalario() - 0.75f;
            jugador.setSalario(nuevoSalario);
        }
    }
}
