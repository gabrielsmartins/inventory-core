package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.enums.StatusOrderEnum;
import br.com.inventory.application.exception.IlegalOrderStateException;

import java.time.LocalDateTime;

public class ReturnedState extends OrderState {

    private final StatusOrderEnum status = StatusOrderEnum.RETURNED;

    public ReturnedState(Order order) {
        super(order);
        this.order.setState(this);
        this.order.setStatus(status);
        var log = new Order.OrderLog(this.order, status, LocalDateTime.now());
        this.order.addLog(log);
    }

    @Override
    public OrderState receive() {
        return null;
    }

    @Override
    public OrderState send() {
        return null;
    }

    @Override
    public OrderState reply() {
        throw new IlegalOrderStateException("Can't receive an order already returned");
    }

    @Override
    public OrderState reject() {
        return new RejectedState(order);
    }

    @Override
    public OrderState finish() {
        return new FinishedState(order);
    }
}
