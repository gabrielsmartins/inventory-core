package br.com.inventory.application.service.products;

import br.com.inventory.application.domain.products.Product;
import br.com.inventory.application.ports.in.products.SearchProductUseCase;
import br.com.inventory.application.ports.out.products.SearchProductPort;
import br.com.inventory.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@UseCase
@RequiredArgsConstructor
public class SearchProductService implements SearchProductUseCase {

    private final SearchProductPort searchProductPort;

    @Override
    public Optional<Product> findById(Long id) {
        return searchProductPort.findById(id);
    }
}
