package br.com.inventory.application.ports.out.orders;

import br.com.inventory.application.domain.orders.Order;

public interface SaveOrderPort {

    Order save(Order save);
}
