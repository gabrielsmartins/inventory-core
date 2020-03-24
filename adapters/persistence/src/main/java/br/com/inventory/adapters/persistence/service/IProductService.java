package br.com.inventory.adapters.persistence.service;


import br.com.inventory.adapters.persistence.entity.ProductEntity;
import br.com.inventory.application.domain.Product;

import java.util.Optional;

public interface IProductService {
   ProductEntity save(ProductEntity productEntity);
   Optional<ProductEntity> findById(Long id);
}
