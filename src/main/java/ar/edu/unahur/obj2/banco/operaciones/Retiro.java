package ar.edu.unahur.obj2.banco.operaciones;

public class Retiro implements IOperacion {

    @Override
    public String getDescripcion() {
        return "RETIRO";
    }

    @Override
    public String mensajeCliente(Double monto) {
        return "Se debitaron $ " + monto;
    }

}
