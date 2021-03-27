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

    @Column(name = "hobby", columnDefinition = "varchar")
    @Enumerated(EnumType.STRING)
    private HobbyEnum hobby;

    public enum HobbyEnum {
        Sports,
        Gaming,
        Traveling,
        Movies,
        Music,
        Cooking,
        Reading,
        Dancing
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

