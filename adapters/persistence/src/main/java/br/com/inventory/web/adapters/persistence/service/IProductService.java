package br.com.inventory.web.adapters.persistence.service;


import br.com.inventory.web.adapters.persistence.entity.ProductEntity;

public interface IProductService {
   ProductEntity save(ProductEntity productEntity);
}
