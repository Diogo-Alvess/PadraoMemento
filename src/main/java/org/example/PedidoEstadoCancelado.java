package org.example;

public class PedidoEstadoCancelado implements PedidoEstado {

    private PedidoEstadoCancelado() {}
    private static PedidoEstadoCancelado instance = new PedidoEstadoCancelado();

    public static PedidoEstadoCancelado getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Cancelado";
    }
}
