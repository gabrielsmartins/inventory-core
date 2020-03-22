package br.com.inventory.adapters.persistence.enums.converter;


import br.com.inventory.adapters.persistence.enums.ProductTypeDataEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProductTypeDataEnumConverter implements AttributeConverter<ProductTypeDataEnum,Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductTypeDataEnum attribute) {
        return ProductTypeDataEnum.getCode();
    }

    @Override
    public ProductTypeDataEnum convertToEntityAttribute(Integer value) {
        return ProductTypeDataEnum.valueOf(value);
    }
}
