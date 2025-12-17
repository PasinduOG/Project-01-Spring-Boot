package com.example.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String city;
}
