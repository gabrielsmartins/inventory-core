package br.com.inventory.adapters.persistence.entity;

import br.com.inventory.adapters.persistence.enums.converter.StatusOrderDataEnumConverter;
import br.com.inventory.application.enums.StatusOrderEnum;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ToString(exclude = {"items","logs"})
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    @Getter
    private Long number;


    @Column(name = "date_time")
    @Getter
    private LocalDateTime dateTime = LocalDateTime.now();


    @Column(name = "status")
    @Getter
    @Convert(converter = StatusOrderDataEnumConverter.class)
    private StatusOrderEnum status;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemEntityId.order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity.OrderItemEntity> items = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderLogEntityId.order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity.OrderLogEntity> logs = new LinkedList<>();

    public OrderEntity(Long number) {
        this.number = number;
    }


    public List<OrderEntity.OrderItemEntity> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<OrderEntity.OrderLogEntity> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public Integer addItem(OrderEntity.OrderItemEntity item) {
        this.items.add(item);
        return this.items.size();
    }

    public Integer addLog(OrderEntity.OrderLogEntity log) {
        this.logs.add(log);
        return this.logs.size();
    }


    @ToString
    @AllArgsConstructor
    @Getter
    public static class OrderItemEntity {

        private OrderItemEntityId itemEntityId;
        private ProductEntity product;
        private BigDecimal amount;

        @ToString
        @RequiredArgsConstructor
        public static class OrderItemEntityId{
            private final OrderEntity order;
        }

    }

    @ToString
    @AllArgsConstructor
    @Getter
    public static class OrderLogEntity {

        private OrderLogEntityId orderLogEntityId;
        private StatusOrderEnum status;

        @RequiredArgsConstructor
        @ToString
        public static class OrderLogEntityId{
            private final OrderEntity orderEntity;
            private final LocalDateTime dateTime;;
        }

    }

}
