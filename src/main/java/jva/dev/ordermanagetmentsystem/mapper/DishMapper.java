package jva.dev.ordermanagetmentsystem.mapper;

import jva.dev.ordermanagetmentsystem.dto.DishDTO;
import jva.dev.ordermanagetmentsystem.model.Dish;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface DishMapper extends Converter<Dish, DishDTO>{

    @Override
    DishDTO convert(Dish source);

}
