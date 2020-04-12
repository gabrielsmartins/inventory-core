package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.exception.IlegalOrderStateException;

public class ReturnedState extends OrderState {

    public ReturnedState(Order order) {
        super(order);
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
