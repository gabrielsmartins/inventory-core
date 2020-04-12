package br.com.inventory.adapters.persistence.mapper.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;
import br.com.inventory.adapters.persistence.enums.StatusOrderDataEnum;
import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.domain.orders.state.OrderState;
import br.com.inventory.application.enums.StatusOrderEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderPersistenceMapper {

    private final OrderItemPersistenceMapper orderItemPersistenceMapper;
    private final OrderLogPersistenceMapper orderLogPersistenceMapper;

    public Order mapToDomain(OrderEntity orderEntity){
        Long id = orderEntity.getId();
        StatusOrderDataEnum status = orderEntity.getStatus();
        LocalDateTime dateTime = orderEntity.getDateTime();
        List<OrderEntity.OrderItemEntity> items = orderEntity.getItems();
        List<OrderEntity.OrderLogEntity> logs = orderEntity.getLogs();
        OrderState state = orderEntity.getState();


        Order order = new Order(id);
        order.setStatus(status.getStatusOrderEnum());
        order.setState(state);
        order.setDateTime(dateTime);
        items.forEach(item -> order.addItem(orderItemPersistenceMapper.mapToDomain(order, item)));
        logs.forEach(log -> order.addLog(orderLogPersistenceMapper.mapToDomain(order, log)));

        return order;
    }

    public OrderEntity mapToEntity(Order order){
        Long id = order.getId();
        StatusOrderEnum status = order.getStatus();
        LocalDateTime dateTime = order.getDateTime();
        List<Order.OrderItem> items = order.getItems();
        List<Order.OrderLog> logs = order.getLogs();
        OrderState state = order.getState();


        OrderEntity orderEntity = new OrderEntity(id);
        orderEntity.setStatus(StatusOrderDataEnum.valueOf(status));
        orderEntity.setState(state);
        orderEntity.setDateTime(dateTime);
        items.forEach(item -> orderEntity.addItem(orderItemPersistenceMapper.mapToEntity(orderEntity, item)));
        logs.forEach(log -> orderEntity.addLog(orderLogPersistenceMapper.mapToEntity(orderEntity, log)));

        return orderEntity;
    }
}
