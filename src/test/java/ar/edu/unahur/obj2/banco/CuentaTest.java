package ar.edu.unahur.obj2.banco;

import org.junit.jupiter.api.Test;
import ar.edu.unahur.obj2.banco.comandos.DepositarComando;
import ar.edu.unahur.obj2.banco.comandos.IComando;
import ar.edu.unahur.obj2.banco.comandos.Invoker;
import ar.edu.unahur.obj2.banco.comandos.RetirarComando;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaTest {

    @Test
    void dadaUnaCuentaCon10000Depositar5000SuSaldoDeberiaSer15000() {
        Cuenta cuenta = new Cuenta(123, 10000.0);

        IComando Deposito = new DepositarComando(cuenta, 5000.0);

        Deposito.ejecutar();

        assertEquals(15000.0, cuenta.getSaldo());
    }

    @Test
    void dadaUnaCuentaCon10000Depositar2000Extracion1000YDeposito3000Eextracion20000SuSaldoDeberiaSer12000() {
        Cuenta cuenta2 = new Cuenta(123, 10000.0);

        IComando Deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando Extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando Deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando Extraccion2 = new RetirarComando(cuenta2, 2000.0);
        Invoker lote = new Invoker();
        lote.agregarComando(Deposito1);
        lote.agregarComando(Extraccion1);
        lote.agregarComando(Deposito2);
        lote.agregarComando(Extraccion2);

        lote.ejecutarLote();

        assertEquals(12000.0, cuenta2.getSaldo());

    }

    @Test
    void dadaUnaCuentaCon10000Depositar2000Extracion1000YDeposito3000Eextracion20000YRevertirLaUltimaEjecucion() {
        Cuenta cuenta2 = new Cuenta(123, 10000.0);

        IComando Deposito1 = new DepositarComando(cuenta2, 2000.0);
        IComando Extraccion1 = new RetirarComando(cuenta2, 1000.0);
        IComando Deposito2 = new DepositarComando(cuenta2, 3000.0);
        IComando Extraccion2 = new RetirarComando(cuenta2, 2000.0);
        Invoker lote = new Invoker();
        lote.agregarComando(Deposito1);
        lote.agregarComando(Extraccion1);
        lote.agregarComando(Deposito2);
        lote.agregarComando(Extraccion2);

        lote.ejecutarLote();
        lote.revertirUltimaEjecucion();

        assertEquals(10000.0, cuenta2.getSaldo());

    }

}
