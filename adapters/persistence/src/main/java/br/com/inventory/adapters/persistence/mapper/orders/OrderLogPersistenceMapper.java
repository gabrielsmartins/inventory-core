package br.com.inventory.adapters.persistence.mapper.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;
import br.com.inventory.adapters.persistence.enums.StatusOrderDataEnum;
import br.com.inventory.application.domain.orders.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class OrderLogPersistenceMapper {

    public Order.OrderLog mapToDomain(Order order, OrderEntity.OrderLogEntity orderLogEntity) {
        var orderLogEntityId = orderLogEntity.getOrderLogEntityId();
        LocalDateTime dateTime =  orderLogEntityId.getDateTime();
        StatusOrderDataEnum status = orderLogEntityId.getStatus();
        var orderLog = new Order.OrderLog(order, status.getStatusOrderEnum(),dateTime);
        return orderLog;
    }

    public OrderEntity.OrderLogEntity mapToEntity(OrderEntity orderEntity, Order.OrderLog orderLog) {
        LocalDateTime dateTime = orderEntity.getDateTime();
        StatusOrderDataEnum statusOrderDataEnum = StatusOrderDataEnum.valueOf(orderLog.getStatus());
        var orderLogEntityId = new OrderEntity.OrderLogEntity.OrderLogEntityId(orderEntity, statusOrderDataEnum, dateTime);
        var orderLogEntity = new OrderEntity.OrderLogEntity(orderLogEntityId);
        return orderLogEntity;
    }
}
