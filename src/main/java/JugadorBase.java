import java.time.LocalDate;

public abstract class JugadorBase {
    String nombre;
    float salario;
    int numCamiseta;
    float calificacion;
    LocalDate fechaContratacion;

    public JugadorBase(String nombre, float salario, int numCamiseta, float calificacion, LocalDate fechaContratacion) {
        this.nombre = nombre;
        this.salario = salario;
        this.numCamiseta = numCamiseta;
        this.calificacion = calificacion;
        this.fechaContratacion = fechaContratacion;
    }

    public float getSalario() {
        return salario;
    }

    public abstract float calcularPorcentaje(float salarioTotal);
}

