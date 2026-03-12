package org.tapesh.addressbookapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tapesh.addressbookapp.entity.Contact;
import org.tapesh.addressbookapp.service.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactSearchController {
    private ContactService contactService;
    public ContactSearchController(ContactService contactService){
        this.contactService = contactService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Contact>> searchByStateAndCity(@RequestParam(required = false) String state, @RequestParam(required = false) String city){
        return ResponseEntity.status(HttpStatus.OK).body(contactService.searchByStateAndCity(state, city));
    }
}
