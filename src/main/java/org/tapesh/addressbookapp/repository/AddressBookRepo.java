package org.tapesh.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tapesh.addressbookapp.entity.AddressBook;

public interface AddressBookRepo extends JpaRepository<AddressBook,Long> {
    public boolean existsByName(String name);
}
