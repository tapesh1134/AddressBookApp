package org.tapesh.addressbookapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.tapesh.addressbookapp.dto.AddressBookDto;
import org.tapesh.addressbookapp.entity.AddressBook;
import org.tapesh.addressbookapp.repository.AddressBookRepo;

@Service
public class AddressBookService {
    private AddressBookRepo addressBookRepo;

    @Autowired
    public AddressBookService(AddressBookRepo addressBookRepo) {
        this.addressBookRepo = addressBookRepo;
    }

    public AddressBook addAddressBook(AddressBookDto addressBook) {
        if(addressBookRepo.existsByName(addressBook.getName())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Address book already exist");
        }
        return addressBookRepo.save(AddressBook.builder().name(addressBook.getName()).build());
    }
}
