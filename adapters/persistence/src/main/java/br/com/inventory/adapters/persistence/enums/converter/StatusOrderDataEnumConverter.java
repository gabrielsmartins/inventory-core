package br.com.inventory.adapters.persistence.enums.converter;

import br.com.inventory.adapters.persistence.enums.StatusOrderDataEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StatusOrderDataEnumConverter implements AttributeConverter<StatusOrderDataEnum, Integer> {


    @Override
    public Integer convertToDatabaseColumn(StatusOrderDataEnum statusOrderDataEnum) {
        return statusOrderDataEnum.getCode();
    }

    @Override
    public StatusOrderDataEnum convertToEntityAttribute(Integer code) {
        return StatusOrderDataEnum.valueOf(code);
    }
}
