package com.example.exploringstarters.controllers;

import com.example.exploringstarters.model.Contact;
import com.example.exploringstarters.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
public class ContactController {

    private final ContactRepository contactRepository;

    @PostMapping
    public void save(Contact contact) {
        contactRepository.save(contact);
    }

    @GetMapping("/unique")
    public List<Contact> getUnique() {
        return contactRepository.findAllWithUniqueNameAndPhonePair();
    }
}
