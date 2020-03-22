package br.com.inventory.adapters.persistence.entity;


import br.com.inventory.adapters.persistence.enums.ProductTypeDataEnum;
import br.com.inventory.adapters.persistence.enums.converter.ProductTypeDataEnumConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;


@Table(name = "Product")
@Entity
@ToString
public class ProductEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
