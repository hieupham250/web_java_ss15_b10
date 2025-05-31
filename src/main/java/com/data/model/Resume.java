package com.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Resume {
    private long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String education;
    private String experience;
    private String skills;
}
