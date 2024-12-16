package jva.dev.ordermanagetmentsystem.mapper;

import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.dto.OrderDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import jva.dev.ordermanagetmentsystem.model.Order;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface OrderDTOMapper extends Converter<OrderDTO, Order>  {

        @Override
        Order convert(OrderDTO source);

}
