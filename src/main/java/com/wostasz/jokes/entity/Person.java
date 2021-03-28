package com.wostasz.jokes.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private int age;


}

