package org.tapesh.addressbookapp.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tapesh.addressbookapp.dto.AddressBookDto;
import org.tapesh.addressbookapp.entity.AddressBook;
import org.tapesh.addressbookapp.service.AddressBookService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    private AddressBookService addressBookService;

    @Autowired
    public AddressBookController(AddressBookService addressBookService) {
        this.addressBookService = addressBookService;
    }

    @PostMapping("/add")
    public ResponseEntity<AddressBook> addAddress(@Valid @RequestBody AddressBookDto addressBookDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressBookService.addAddressBook(addressBookDto));
    }
}
