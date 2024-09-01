package customer;

import customer.dto.CustomerInfoDTO;
import customer.dto.SendCustomerDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<Page<CustomerInfoDTO>> getAll(Pageable pageable){
        Page<CustomerInfoDTO> allCustomersPage = customerService.getAll(pageable);
        return ResponseEntity.ok(allCustomersPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDTO> getById(@PathVariable Integer id){
        CustomerInfoDTO customer = customerService.getById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/post")
    public ResponseEntity<CustomerInfoDTO> create(@Valid @RequestBody SendCustomerDTO dto){
        CustomerInfoDTO createdCustomer = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerInfoDTO> update(@PathVariable Integer id, @Valid @RequestBody String email){
        CustomerInfoDTO updatedCustomer = customerService.updateCustomer(id, email);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
