package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private PedidoEstado estado;
    private List<PedidoEstado> memento = new ArrayList<>();

    public PedidoEstado getEstado() {
        return this.estado;
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
        this.memento.add(estado);
    }

    public void restauraEstado(int indice) {
        if (indice < 0 || indice > memento.size() - 1) {
            throw new IllegalArgumentException("Índice inválido");
        }
        this.estado = this.memento.get(indice);
    }

    public List<PedidoEstado> getEstados() {
        return this.memento;
    }
}
