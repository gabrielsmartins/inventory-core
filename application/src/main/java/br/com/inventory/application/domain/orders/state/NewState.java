package br.com.inventory.application.domain.orders.state;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.enums.StatusOrderEnum;
import br.com.inventory.application.exception.IlegalOrderStateException;

public class NewState extends OrderState {

    private final StatusOrderEnum status = StatusOrderEnum.NEW;

    public NewState(Order order) {
        super(order);
    }

    @Override
    public OrderState receive() {
        return new ReceivedState(order);
    }

    @Override
    public OrderState send() {
        throw new IlegalOrderStateException("Can't send an order that still in a new state");
    }

    @Override
    public OrderState reply() {
        throw new IlegalOrderStateException("Can't reply an order that still in a new state");
    }

    @Override
    public OrderState reject() {
        throw new IlegalOrderStateException("Can't reject an order that still in a new state");
    }

    @Override
    public OrderState finish() {
        throw new IlegalOrderStateException("Can't finish an order that still in a new state");
    }
}
