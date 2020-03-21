package br.com.inventory.web.adapters.persistence.service;

import br.com.inventory.web.adapters.persistence.entity.ProductEntity;
import br.com.inventory.web.adapters.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository repository;

    @Override
    public ProductEntity save(ProductEntity productEntity) {
        return repository.save(productEntity);
    }
}
