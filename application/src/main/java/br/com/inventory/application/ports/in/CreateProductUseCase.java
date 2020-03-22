package br.com.inventory.application.ports.in;


import br.com.inventory.application.domain.Product;

public interface CreateProductUseCase {

    Product create(Product product);
}
