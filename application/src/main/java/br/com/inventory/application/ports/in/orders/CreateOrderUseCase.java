package br.com.inventory.application.ports.in.orders;

import br.com.inventory.application.domain.orders.Order;


public interface CreateOrderUseCase {
    Order create(Order order);
}
