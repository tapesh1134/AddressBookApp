package org.tapesh.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tapesh.addressbookapp.entity.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Long> {
}
