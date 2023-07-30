package com.example.exploringstarters.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@NoArgsConstructor
public class Contact {

    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    @GeneratedValue
    private UUID uuid;

    private String name;
    private String phone;

}
