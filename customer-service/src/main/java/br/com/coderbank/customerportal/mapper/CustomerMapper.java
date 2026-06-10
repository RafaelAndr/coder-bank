package br.com.coderbank.customerportal.mapper;

import br.com.coderbank.customerportal.dto.request.CreateAccountRequestDto;
import br.com.coderbank.customerportal.dto.request.CustomerRequestDto;
import br.com.coderbank.customerportal.dto.response.CustomerListDto;
import br.com.coderbank.customerportal.dto.response.CustomerResponseDto;
import br.com.coderbank.customerportal.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerRequestDto dto);

    CustomerResponseDto toDto(Customer customer);

    @Mapping(source = "id", target = "customerId")
    CreateAccountRequestDto toCreateAccountDto(Customer customer);

    CustomerListDto toPagedDto(Customer customer);
}
