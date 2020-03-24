package br.com.inventory.application.ports.out;

import br.com.inventory.application.domain.Product;

import java.util.Optional;

public interface SearchProductPort {
    Optional<Product> findById(Long id);
}
