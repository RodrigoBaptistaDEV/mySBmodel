package customer.dto;

import jakarta.validation.constraints.NotNull;

public record SendCustomerDTO(
        @NotNull
        Integer customerId,

        @NotNull
        Character firstName,

        @NotNull
        Character lastName,

        @NotNull
        Character email
) {

}
