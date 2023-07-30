package com.example.exploringstarters.repository;

import com.example.exploringstarters.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContactRepository extends JpaRepository<Contact, UUID> {

    @Query("select contact from (select numeredContact, row_number() over(partition by numeredContact.name, numeredContact.phone) as num from Contact numeredContact ) as contact where contact.num = 1")
    List<Contact> findAllWithUniqueNameAndPhonePair();
}
