package br.com.inventory.adapters.persistence.service;


import br.com.inventory.adapters.persistence.entity.ProductEntity;

public interface IProductService {
   ProductEntity save(ProductEntity productEntity);
}
