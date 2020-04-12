package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.enums.StatusOrderEnum;
import br.com.inventory.application.exception.IlegalOrderStateException;

import java.time.LocalDateTime;

public class ReceivedState extends OrderState {

    private final StatusOrderEnum status = StatusOrderEnum.RECEIVED;

    public ReceivedState(Order order) {
        super(order);
        this.order.setState(this);
        this.order.setStatus(status);
        var log = new Order.OrderLog(this.order, status, LocalDateTime.now());
        this.order.addLog(log);
    }

    @Override
    public OrderState receive() {
        throw new IlegalOrderStateException("Can't receive an order already received");
    }

    @Override
    public OrderState send() {
        return new SentState(order);
    }

    @Override
    public OrderState reply() {
        throw new IlegalOrderStateException("Can't reply an order that was not received yet");
    }

    @Override
    public OrderState reject() {
        throw new IlegalOrderStateException("Can't reject an order that was not received yet");
    }

    @Override
    public OrderState finish() {
        throw new IlegalOrderStateException("Can't finish an order that was not received yet");
    }
}
