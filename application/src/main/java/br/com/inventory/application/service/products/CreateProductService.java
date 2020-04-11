package br.com.inventory.application.service.products;

import br.com.inventory.application.domain.products.Product;
import br.com.inventory.application.ports.in.products.CreateProductUseCase;
import br.com.inventory.application.ports.out.products.SaveProductPort;
import br.com.inventory.shared.annotations.UseCase;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CreateProductService implements CreateProductUseCase {

    private final SaveProductPort saveProductPort;

    @Override
    public Product create(Product product) {
        return saveProductPort.save(product);
    }
}
