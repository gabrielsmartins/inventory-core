package br.com.inventory.adapters.persistence.entity;


import br.com.inventory.adapters.persistence.enums.ProductTypeDataEnum;
import br.com.inventory.adapters.persistence.enums.converter.ProductTypeDataEnumConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@Table(name = "tbl_product")
@Entity
@ToString
public class ProductEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
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
