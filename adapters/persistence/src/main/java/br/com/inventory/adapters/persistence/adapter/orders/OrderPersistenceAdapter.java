package br.com.inventory.adapters.persistence.adapter.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;
import br.com.inventory.adapters.persistence.mapper.orders.OrderPersistenceMapper;
import br.com.inventory.adapters.persistence.service.orders.IOrderService;
import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.ports.out.orders.SaveOrderPort;
import br.com.inventory.shared.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements SaveOrderPort {

    private final IOrderService orderService;
    private final OrderPersistenceMapper mapper;

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = mapper.mapToEntity(order);
        orderService.save(orderEntity);
        order = mapper.mapToDomain(orderEntity);
        return order;
    }
}
