package org.tapesh.addressbookapp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.tapesh.addressbookapp.dto.ContactDto;
import org.tapesh.addressbookapp.entity.AddressBook;
import org.tapesh.addressbookapp.entity.Contact;
import org.tapesh.addressbookapp.repository.AddressBookRepo;
import org.tapesh.addressbookapp.repository.ContactRepo;

@Service
public class ContactService {
    private ContactRepo contactRepo;
    private AddressBookRepo addressBookRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo, AddressBookRepo addressBookRepo){
        this.contactRepo = contactRepo;
        this.addressBookRepo = addressBookRepo;
    }

    public Contact addContact(Long addressBookId, ContactDto addContactDto) {
        AddressBook book = addressBookRepo.findById(addressBookId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_CONTENT, "Address Book Not Found"));
        return contactRepo.save(Contact.builder().firstName(addContactDto.getFirstName()).lastName(addContactDto.getLastName()).email(addContactDto.getEmail()).phone(addContactDto.getPhoneNumber()).address(addContactDto.getAddress()).city(addContactDto.getCity()).state(addContactDto.getState()).zip(addContactDto.getZip()).addressBook(book).build());
    };
}
