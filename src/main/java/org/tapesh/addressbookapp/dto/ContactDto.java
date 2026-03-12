package org.tapesh.addressbookapp.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]{3,20}$", message = "first name is not valid")
    private String firstName;
    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]{3,20}$", message = "Last name must contain only letters (3-20 characters)")
    private String lastName;
    @NotBlank(message = "Address cannot be empty")
    @Size(min = 5, max = 100, message = "Address must be between 5 and 100 characters")
    @Pattern(regexp = "^[A-Za-z0-9 ,./#-]+$", message = "Address contains invalid characters")
    private String address;
    @NotBlank(message = "City cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{2,30}$", message = "City must contain only letters")
    private String city;
    @NotBlank(message = "State cannot be empty")
    @Pattern(regexp = "^[A-Za-z ]{2,30}$", message = "State must contain only letters")
    private String state;
    @NotBlank(message = "Zip code cannot be empty")
    @Pattern(regexp = "^[0-9]{5,6}$", message = "Zip code must be 5 or 6 digits")
    private String zip;
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone number must be a valid 10 digit Indian number")
    private String phoneNumber;
    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email must be valid")
    private String email;
}
