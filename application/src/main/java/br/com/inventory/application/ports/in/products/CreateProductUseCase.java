package br.com.inventory.application.ports.in.products;


import br.com.inventory.application.domain.products.Product;

public interface CreateProductUseCase {

    Product create(Product product);
}
