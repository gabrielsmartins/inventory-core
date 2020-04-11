package br.com.inventory.adapters.persistence.service.orders;

import br.com.inventory.adapters.persistence.entity.OrderEntity;
import br.com.inventory.adapters.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {

    private final OrderRepository repository;

    @Override
    public OrderEntity save(OrderEntity orderEntity) {
        return repository.saveAndFlush(orderEntity);
    }

}
