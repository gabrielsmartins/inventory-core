package br.com.inventory.adapters.persistence.service.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;

public interface IOrderService {
    OrderEntity save(OrderEntity orderEntity);
}
