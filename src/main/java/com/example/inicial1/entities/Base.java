package com.example.inicial1.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Base implements Serializable {  //cualquier clase que herede de Base va a implementar Serializable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
