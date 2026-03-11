package org.tapesh.addressbookapp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDto {
    @NotBlank(message = "Address book name cannot be empty")
    @Pattern(regexp = "^[A-Za-z]{3,20}$", message = "Address book name is not valid")
    private String name;
}
