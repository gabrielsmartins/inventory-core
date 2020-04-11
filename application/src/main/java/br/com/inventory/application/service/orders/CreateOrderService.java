package br.com.inventory.application.service.orders;

import br.com.inventory.application.domain.orders.Order;
import br.com.inventory.application.ports.in.orders.CreateOrderUseCase;
import br.com.inventory.application.ports.out.orders.SaveOrderPort;
import br.com.inventory.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateOrderService implements CreateOrderUseCase {

    private final SaveOrderPort saveOrderPort;

    @Override
    public Order create(Order order) {
        return saveOrderPort.save(order);
    }
}
