package customer.dto;

public record CustomerInfoDTO(
        Integer customerId,
        String firstName,
        String lastName,
        String company,
        String city,
        String state,
        String country,
        String email
        ) {
}
