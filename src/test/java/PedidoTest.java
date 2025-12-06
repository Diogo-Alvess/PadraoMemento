package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido();
    }

    @Test
    void deveArmazenarEstados() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoProcessando.getInstance());
        pedido.setEstado(PedidoEstadoEnviado.getInstance());

        assertEquals(3, pedido.getEstados().size());
    }

    @Test
    void deveRetornarEstadoAtual() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoProcessando.getInstance());

        assertEquals("Processando", pedido.getEstado().getNomeEstado());
    }

    @Test
    void deveRestaurarEstadoAnterior() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoProcessando.getInstance());
        pedido.setEstado(PedidoEstadoEnviado.getInstance());

        pedido.restauraEstado(0);

        assertEquals("Criado", pedido.getEstado().getNomeEstado());
    }

    @Test
    void deveLancarExcecaoIndiceInvalido() {
        try {
            pedido.restauraEstado(5);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Índice inválido", e.getMessage());
        }
    }

    @Test
    void deveRestaurarUltimoEstado() {
        pedido.setEstado(PedidoEstadoCriado.getInstance());
        pedido.setEstado(PedidoEstadoProcessando.getInstance());
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        pedido.setEstado(PedidoEstadoEntregue.getInstance());

        pedido.restauraEstado(3);

        assertEquals("Entregue", pedido.getEstado().getNomeEstado());
    }
}