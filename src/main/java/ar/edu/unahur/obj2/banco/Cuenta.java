package ar.edu.unahur.obj2.banco;

import ar.edu.unahur.obj2.banco.observadores.IObservadorCuenta;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unahur.obj2.banco.operaciones.IOperacion;
import ar.edu.unahur.obj2.banco.operaciones.Deposito;
import ar.edu.unahur.obj2.banco.operaciones.Retiro;

public class Cuenta {
    private final Integer numero;
    private Double saldo;
    private List<IObservadorCuenta> observadores = new ArrayList<>();

    public Cuenta(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void depositar(Double monto) {
        this.saldo += monto;
        notificar(new Deposito(), monto);
    }

    public void retirar(Double monto) {
        this.saldo -= monto;
        notificar(new Retiro(), monto);
    }

    public void notificar(IOperacion operacion, Double monto) {
        observadores.forEach(observador -> observador.notificar(this, operacion, monto));
    }

    public void agregarObservador(IObservadorCuenta observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(IObservadorCuenta observador) {
        observadores.remove(observador);
    }
}
