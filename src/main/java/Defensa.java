import java.time.LocalDate;

class Defensa extends JugadorBase {
    public Defensa(String nombre, float salario, int numCamiseta, float calificacion, LocalDate fechaContratacion) {
        super(nombre, salario, numCamiseta, calificacion, fechaContratacion);
    }

    @Override
    public float calcularPorcentaje(float salarioTotal) {
        return (salario / salarioTotal) * 100;
    }
}
