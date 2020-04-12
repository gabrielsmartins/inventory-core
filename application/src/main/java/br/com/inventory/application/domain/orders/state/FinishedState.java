package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.exception.IlegalOrderStateException;

public class FinishedState extends OrderState {

    public FinishedState(Order order) {
        super(order);
    }

    @Override
    public OrderState receive() {
        throw new IlegalOrderStateException("Can't receive an order already finished");
    }

    @Override
    public OrderState send() {
        throw new IlegalOrderStateException("Can't send an order already finished");
    }

    @Override
    public OrderState reply() {
        throw new IlegalOrderStateException("Can't reply an order already finished");
    }

    @Override
    public OrderState reject() {
        throw new IlegalOrderStateException("Can't reject an order already finished");
    }

    @Override
    public OrderState finish() {
        throw new IlegalOrderStateException("Can't finish an order already finished");
    }
}
