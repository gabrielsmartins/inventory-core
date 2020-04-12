package br.com.inventory.adapters.persistence.entity;

import br.com.inventory.adapters.persistence.enums.StatusOrderDataEnum;
import br.com.inventory.adapters.persistence.enums.converter.StatusOrderDataEnumConverter;
import br.com.inventory.application.domain.orders.state.OrderState;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "tbl_order")
@ToString(exclude = {"items","logs"})
@NoArgsConstructor
public class OrderEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Getter
    private Long id;


    @Column(name = "date_time")
    @Getter
    @Setter
    private LocalDateTime dateTime = LocalDateTime.now();


    @Column(name = "status")
    @Getter
    @Setter
    @Convert(converter = StatusOrderDataEnumConverter.class)
    private StatusOrderDataEnum status;

    @Getter
    @Setter
    @Transient
    private OrderState state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "itemEntityId.order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity.OrderItemEntity> items = new LinkedList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderLogEntityId.order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderEntity.OrderLogEntity> logs = new LinkedList<>();

    public OrderEntity(Long id) {
        this.id = id;
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


    @Entity
    @Table(name = "tbl_order_item")
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class OrderItemEntity implements Serializable{

        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private OrderItemEntityId itemEntityId;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "product_id", referencedColumnName = "product_id")
        private ProductEntity product;

        @Column(name = "amount")
        private BigDecimal amount;

        @ToString
        @RequiredArgsConstructor
        @Embeddable
        public static class OrderItemEntityId implements Serializable{

            private static final long serialVersionUID = 1L;

            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "order_id", referencedColumnName = "order_id")
            private final OrderEntity order;
        }

    }

    @Entity
    @Table(name = "tbl_order_log")
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class OrderLogEntity implements Serializable{

        private static final long serialVersionUID = 1L;

        @EmbeddedId
        private OrderLogEntityId orderLogEntityId;

        @Column(name = "status")
        @Convert(converter = StatusOrderDataEnumConverter.class)
        private StatusOrderDataEnum status;

        @RequiredArgsConstructor
        @ToString
        @Embeddable
        @Getter
        public static class OrderLogEntityId implements Serializable{

            private static final long serialVersionUID = 1L;

            @ManyToOne(fetch = FetchType.LAZY)
            @JoinColumn(name = "order_id", referencedColumnName = "order_id")
            private final OrderEntity order;

            @Column(name = "date_time")
            private final LocalDateTime dateTime;;
        }

    }

}
