package br.com.inventory.adapters.persistence.mapper.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;
import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.adapters.persistence.mapper.products.ProductPersistenceMapper;
import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.domain.products.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class OrderItemPersistenceMapper {

    private final ProductPersistenceMapper productPersistenceMapper;

    public Order.OrderItem mapToDomain(Order order, OrderEntity.OrderItemEntity orderItemEntity){
        var product = productPersistenceMapper.mapToDomain(orderItemEntity.getProduct());
        BigDecimal amount =  orderItemEntity.getAmount();
        var orderItem = new Order.OrderItem(order, product,amount);
        return orderItem;
    }

    public OrderEntity.OrderItemEntity mapToEntity(OrderEntity orderEntity, Order.OrderItem orderItem){
        var orderItemEntityId = new  OrderEntity.OrderItemEntity.OrderItemEntityId(orderEntity);
        Product product = orderItem.getProduct();
        ProductEntity productEntity = productPersistenceMapper.mapToEntity(product);
        BigDecimal amount = orderItem.getAmount();
        var orderItemEntity =new OrderEntity.OrderItemEntity(orderItemEntityId, productEntity ,amount);
        return orderItemEntity;
    }
}
