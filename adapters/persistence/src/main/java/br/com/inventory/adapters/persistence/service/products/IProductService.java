package br.com.inventory.adapters.persistence.service.products;


import br.com.inventory.adapters.persistence.entity.ProductEntity;

import java.util.Optional;

public interface IProductService {
   ProductEntity save(ProductEntity productEntity);
   Optional<ProductEntity> findById(Long id);
}
