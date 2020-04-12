package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.exception.IlegalOrderStateException;

public class SentState extends OrderState {

    public SentState(Order order) {
        super(order);
    }

    @Override
    public OrderState receive() {
        throw new IlegalOrderStateException("Can't receive an order already sent");
    }

    @Override
    public OrderState send() {
        return new SentState(order);
    }

    @Override
    public OrderState reply() {
        return new ReturnedState(order);
    }

    @Override
    public OrderState reject() {
        throw new IlegalOrderStateException("Can't reject an order that was not sent yet");
    }

    @Override
    public OrderState finish() {
        throw new IlegalOrderStateException("Can't finish an order that was not sent yet");
    }
}
