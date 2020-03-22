package br.com.inventory.adapters.persistence.adapter;

import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.adapters.persistence.mapper.ProductPersistenceMapper;
import br.com.inventory.adapters.persistence.service.ProductService;
import br.com.inventory.application.domain.Product;
import br.com.inventory.application.ports.out.SaveProductPort;
import br.com.inventory.common.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort {

    private final ProductService productService;
    private final ProductPersistenceMapper mapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.mapToEntity(product);
        productService.save(productEntity);
        return mapper.mapToDomain(productEntity);
    }
}
