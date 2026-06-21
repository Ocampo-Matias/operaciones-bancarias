package ar.edu.unahur.obj2.banco.comandos;

import java.util.ArrayList;
import java.util.List;

public class Invoker {

    private List<IComando> comandosEjecutados = new ArrayList<>();
    private List<IComando> ultimosComandos = new ArrayList<>();

    public void agregarComando(IComando comando) {
        comandosEjecutados.add(comando);
    }

    public void ejecutarLote() {
        comandosEjecutados.forEach(IComando::ejecutar);
        comandosEjecutados.forEach(ultimosComandos::add);
        comandosEjecutados.clear();
    }

    public void revertirUltimaEjecucion() {
        ultimosComandos.forEach(IComando::deshacer);
    }

}
