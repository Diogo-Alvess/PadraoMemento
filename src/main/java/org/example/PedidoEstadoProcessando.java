package org.example;

public class PedidoEstadoProcessando implements PedidoEstado {

    private PedidoEstadoProcessando() {}
    private static PedidoEstadoProcessando instance = new PedidoEstadoProcessando();

    public static PedidoEstadoProcessando getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Processando";
    }
}