package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;

public abstract class OrderState {

    protected Order order;

    public OrderState(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public abstract OrderState receive();

    public abstract OrderState send();

    public abstract OrderState reply();

    public abstract OrderState reject();

    public abstract OrderState finish();
}
