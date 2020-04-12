package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.exception.IlegalOrderStateException;

public class ReceivedState extends OrderState {


    public ReceivedState(Order order) {
        super(order);
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
