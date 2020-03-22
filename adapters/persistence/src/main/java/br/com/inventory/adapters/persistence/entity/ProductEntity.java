package br.com.inventory.adapters.persistence.entity;


import br.com.inventory.adapters.persistence.enums.ProductTypeDataEnum;
import br.com.inventory.adapters.persistence.enums.converter.ProductTypeDataEnumConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Convert;
import java.math.BigDecimal;


@ToString
public class ProductEntity {

    @Getter
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @Getter
    @Setter
    @Column(name = "type")
    @Convert(converter = ProductTypeDataEnumConverter.class)
    private ProductTypeDataEnum type;

    @Getter
    @Setter
    @Column(name = "amount")
    private BigDecimal amount;
}
