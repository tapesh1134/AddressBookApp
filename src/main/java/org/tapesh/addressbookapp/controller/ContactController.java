package org.tapesh.addressbookapp.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.tapesh.addressbookapp.dto.ContactDto;
import org.tapesh.addressbookapp.entity.Contact;
import org.tapesh.addressbookapp.service.ContactService;

@RestController
@RequestMapping("/addressbook/{addressBookId}")
public class ContactController {
    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> addContact(@PathVariable Long addressBookId, @Valid @RequestBody ContactDto contactDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.addContact(addressBookId, contactDto));
    }

}
