import java.time.LocalDate;

class Arquero extends JugadorBase {
    public Arquero(String nombre, float salario, int numCamiseta, float calificacion, LocalDate fechaContratacion) {
        super(nombre, salario, numCamiseta, calificacion, fechaContratacion);
    }

    @Override
    public float calcularPorcentaje(float salarioTotal) {
        return (salario / salarioTotal) * 100;
    }
}
