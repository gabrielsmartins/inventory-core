package br.com.inventory.application.ports.out;

import br.com.inventory.application.domain.Product;

public interface SaveProductPort {

    Product save(Product product);
}
