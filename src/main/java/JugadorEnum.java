import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class JugadorEnum {
    String nombre;
    float salario, calificacion;
    int numCamiseta;
    Posicion posJuego;
    LocalDate fechaContratacion;

    public JugadorEnum(String nombre, float salario, float calificacion, int numCamiseta, Posicion posJuego, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.salario = salario;
        this.calificacion = calificacion;
        this.numCamiseta = numCamiseta;
        this.posJuego = posJuego;
        this.fechaContratacion = fechaContratacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    public int getNumCamiseta() {
        return numCamiseta;
    }

    public void setNumCamiseta(int numCamiseta) {
        this.numCamiseta = numCamiseta;
    }

    public Posicion getPosJuego() {
        return posJuego;
    }

    public void setPosJuego(Posicion posJuego) {
        this.posJuego = posJuego;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    /**
     * metodo para calcular los años de antiguedad de un jugador
     * @return
     */
    public int calcularAntiguedad(){
        return (int) ChronoUnit.YEARS.between(fechaContratacion, LocalDate.now());
    }

}
