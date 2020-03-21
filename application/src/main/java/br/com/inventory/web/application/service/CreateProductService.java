package br.com.inventory.web.application.service;

import br.com.inventory.web.application.domain.Product;
import br.com.inventory.web.application.ports.in.CreateProductUseCase;
import br.com.inventory.web.application.ports.out.SaveProductPort;
import br.com.inventory.web.common.annotations.UseCase;
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
