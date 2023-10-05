package com.registration.user.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name="users")
public class User {

    @Id
    private int userId;
    private String userName;
    private String userPassword;
    private String userAddress;
    private String userState;
    private String userCountry;
    private String userEmail;
    private String userPan;
    private String userContact;
    private String userDob;
    private String userAccType;
}
