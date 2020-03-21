package br.com.inventory.web.application.ports.in;

import br.com.inventory.web.application.domain.Product;

public interface CreateProductUseCase {

    Product create(Product product);
}
