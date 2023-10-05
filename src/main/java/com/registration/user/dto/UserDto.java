package com.registration.user.dto;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDto {

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
