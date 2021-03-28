package com.wostasz.jokes.domain;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "person_db")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`Name`", unique = true)
    private String name;

    @Column(name = "`Age`")
    private int age;

    @Column(name = "`Hobby`")
    private HobbyEnum hobbyEnum;

}

