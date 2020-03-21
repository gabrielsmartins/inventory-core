package br.com.inventory.web.application.ports.out;

import br.com.inventory.web.application.domain.Product;

public interface SaveProductPort {

    Product save(Product product);
}
