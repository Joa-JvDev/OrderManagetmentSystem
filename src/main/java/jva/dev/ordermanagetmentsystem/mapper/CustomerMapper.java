package jva.dev.ordermanagetmentsystem.mapper;


import jva.dev.ordermanagetmentsystem.dto.CustomerDTO;
import jva.dev.ordermanagetmentsystem.model.Customer;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends Converter<Customer, CustomerDTO> {

    @Override
    CustomerDTO convert(Customer source);
}
