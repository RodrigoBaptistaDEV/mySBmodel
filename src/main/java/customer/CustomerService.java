package customer;

import customer.dto.CustomerInfoDTO;
import customer.dto.SendCustomerDTO;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    private Customer getEntityById(Integer id){
        return customerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<CustomerInfoDTO> getAll(Pageable pageable) {
        Page<Customer> entityPage = customerRepository.findAll(pageable);
        return entityPage.map(e -> modelMapper.map(e, CustomerInfoDTO.class));
    }

    public CustomerInfoDTO getById(Integer id) {
        return modelMapper.map(getEntityById(id), CustomerInfoDTO.class);
    }

    public CustomerInfoDTO createCustomer(@Valid SendCustomerDTO dto) {
        Customer savedCustomer = customerRepository.save(modelMapper.map(dto, Customer.class));
        return modelMapper.map(savedCustomer,CustomerInfoDTO.class);
    }

    public CustomerInfoDTO updateCustomer(Integer id, @Valid String email) {
        Customer customer = getEntityById(id);
        customer.setEmail(email);
        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer,CustomerInfoDTO.class);
    }

    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }
}
