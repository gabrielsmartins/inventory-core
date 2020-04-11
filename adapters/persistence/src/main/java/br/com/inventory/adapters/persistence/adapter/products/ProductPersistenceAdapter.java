package br.com.inventory.adapters.persistence.adapter.products;

import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.adapters.persistence.mapper.products.ProductPersistenceMapper;
import br.com.inventory.adapters.persistence.service.products.ProductService;
import br.com.inventory.application.domain.products.Product;
import br.com.inventory.application.ports.out.products.SaveProductPort;
import br.com.inventory.application.ports.out.products.SearchProductPort;
import br.com.inventory.shared.annotations.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements SaveProductPort, SearchProductPort {

    private final ProductService productService;
    private final ProductPersistenceMapper mapper;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = mapper.mapToEntity(product);
        productService.save(productEntity);
        product = mapper.mapToDomain(productEntity);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Optional<ProductEntity> optional = productService.findById(id);
        if(optional.isPresent()){
            return  Optional.ofNullable(mapper.mapToDomain(optional.get()));
        }
        return Optional.empty();
    }
}
