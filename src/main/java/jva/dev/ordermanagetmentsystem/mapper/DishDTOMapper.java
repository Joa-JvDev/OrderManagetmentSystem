package jva.dev.ordermanagetmentsystem.mapper;

import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Dish;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DishDTOMapper extends Converter<DishDTO, Dish> {

    @Override
    Dish convert(DishDTO source);

}
