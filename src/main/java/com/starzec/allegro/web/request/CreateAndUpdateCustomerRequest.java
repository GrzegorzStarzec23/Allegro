package com.starzec.allegro.web.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAndUpdateCustomerRequest {
    @Column(nullable = false, length = 255)
    private String firstName;
    @Column(nullable = false, length = 255)
    private String lastName;
    @Email
    private String email;
    @Column(nullable = false)
    @Pattern(regexp = "^[0-9]{9}$", message = "Invalid phone number format")
    private String phone;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    @Pattern(regexp = "^[0-9]{5}$", message = "Invalid code number format, try to enter the postal code without the dash ")
    private String postalCode;
}
