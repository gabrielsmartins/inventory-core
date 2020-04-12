package br.com.inventory.application.service.orders;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.ports.in.orders.SubmitOrderUseCase;
import br.com.inventory.application.ports.out.orders.SaveOrderPort;
import br.com.inventory.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class SubmitOrderService implements SubmitOrderUseCase {

    private final SaveOrderPort saveOrderPort;

    @Override
    public Order submit(Order order) {
        order.receive();
        order.send();
        return saveOrderPort.save(order);
    }
}
