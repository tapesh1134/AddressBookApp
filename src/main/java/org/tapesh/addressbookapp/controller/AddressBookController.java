package org.tapesh.addressbookapp.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tapesh.addressbookapp.dto.AddressBookDto;
import org.tapesh.addressbookapp.entity.AddressBook;
import org.tapesh.addressbookapp.service.AddressBookService;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllAddressBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(addressBookService.getAddressBooks());
    }
}
