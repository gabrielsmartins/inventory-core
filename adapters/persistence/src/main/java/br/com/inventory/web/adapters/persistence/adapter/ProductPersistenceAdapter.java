package br.com.inventory.web.adapters.persistence.adapter;

import br.com.inventory.web.adapters.persistence.entity.ProductEntity;
import br.com.inventory.web.adapters.persistence.mapper.ProductPersistenceMapper;
import br.com.inventory.web.adapters.persistence.service.ProductService;
import br.com.inventory.web.application.domain.Product;
import br.com.inventory.web.application.ports.out.SaveProductPort;
import br.com.inventory.web.common.annotations.PersistenceAdapter;
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
