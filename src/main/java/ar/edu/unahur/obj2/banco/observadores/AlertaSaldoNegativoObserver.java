package ar.edu.unahur.obj2.banco.observadores;

import java.util.List;

import ar.edu.unahur.obj2.banco.Cuenta;
import ar.edu.unahur.obj2.banco.operaciones.IOperacion;
import java.util.ArrayList;

public class AlertaSaldoNegativoObserver implements IObservadorCuenta {
    private List<Cuenta> cuentasEnAlerta = new ArrayList<>();

    @Override
    public void notificar(Cuenta cuenta, IOperacion operacion, Double monto) {
        if (cuenta.getSaldo() < 0) {
            System.out.println("Alerta: saldo negativo en la cuenta " + cuenta.getNumero());
            cuentasEnAlerta.add(cuenta);
        }
    }

    public List<Cuenta> getCuentasEnAlerta() {
        return cuentasEnAlerta;
    }

}
