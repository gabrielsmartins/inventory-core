package br.com.inventory.adapters.persistence.service;


import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.adapters.persistence.repository.ProductRepository;
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
