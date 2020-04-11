package br.com.inventory.application.ports.out.products;

import br.com.inventory.application.domain.products.Product;

public interface SaveProductPort {

    Product save(Product product);
}
