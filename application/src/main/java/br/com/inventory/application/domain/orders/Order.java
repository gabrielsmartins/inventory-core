package br.com.inventory.application.domain.orders;

import br.com.inventory.application.domain.orders.state.NewState;
import br.com.inventory.application.domain.orders.state.OrderState;
import br.com.inventory.application.domain.products.Product;
import br.com.inventory.application.enums.StatusOrderEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@ToString(exclude = {"items","logs"})
@RequiredArgsConstructor
public class Order {

    @Getter
    private final Long number;
    @Getter
    private LocalDateTime dateTime = LocalDateTime.now();
    @Getter
    private StatusOrderEnum status;

    private OrderState state = new NewState(this);

    private List<OrderItem> items = new LinkedList<>();
    private List<OrderLog> logs= new LinkedList<>();


    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<OrderLog> getLogs() {
        return Collections.unmodifiableList(logs);
    }

    public Integer addItem(OrderItem item){
        this.items.add(item);
        return this.items.size();
    }

    public Integer addLog(OrderLog log){
        this.logs.add(log);
        return this.logs.size();
    }

    public OrderState receive() {
        this.state.receive();
        return this.state;
    }

    public OrderState send() {
        this.state.send();
        return this.state;
    }

    public OrderState reply() {
        this.state.reply();
        return this.state;
    }

    public OrderState reject() {
        this.state.reject();
        return this.state;
    }

    public OrderState finish() {
        this.state.finish();
        return this.state;
    }

    @ToString
    @AllArgsConstructor
    @Getter
    public static class OrderItem{

        private Product product;
        private BigDecimal amount;

    }

    @ToString
    @AllArgsConstructor
    @Getter
    public static class OrderLog{

        private StatusOrderEnum status;
        private LocalDateTime dateTime;

    }
}
