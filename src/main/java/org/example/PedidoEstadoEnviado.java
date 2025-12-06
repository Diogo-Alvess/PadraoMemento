package org.example;

public class PedidoEstadoEnviado implements PedidoEstado {

    private PedidoEstadoEnviado() {}
    private static PedidoEstadoEnviado instance = new PedidoEstadoEnviado();

    public static PedidoEstadoEnviado getInstance() {
        return instance;
    }

    @Override
    public String getNomeEstado() {
        return "Enviado";
    }
}
