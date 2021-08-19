package guru.springframework.msscbrewery.web.service;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomerById(UUID id) {
        return CustomerDto.builder()
                .id( UUID.randomUUID() )
                .name("Lázaro Cobiella")
                .build();
    }

    @Override
    public CustomerDto saveNewCustomer(CustomerDto customerDto) {
        return CustomerDto.builder()
                .id( UUID.randomUUID() )
                .build();
    }

    @Override
    public void updateCustomer(UUID id, CustomerDto customerDto) {
        // TODO Impl
    }

    @Override
    public void deleteCustomerById(UUID id) {
        log.debug("Deleting customer " + id);
        // TODO Impl
    }
}
