package ar.edu.unahur.obj2.banco.observadores;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.operaciones.IOperacion;

public class AuditoriaObtener implements IObservadorCuenta {
    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        System.out.println(
                "[Auditoria] Cuenta: " + cuenta.getNumero() +
                        " - Operacion: " + operacion.getDescripcion() +
                        " - Monto: " + monto);

    }

}
