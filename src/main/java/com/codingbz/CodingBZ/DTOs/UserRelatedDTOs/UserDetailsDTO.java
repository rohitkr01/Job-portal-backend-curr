package com.codingbz.CodingBZ.DTOs.UserRelatedDTOs;

import lombok.Data;

@Data
public class UserDetailsDTO {
    private String username;
    private String password;
    private String email;
    private String name;
    private Long mobileNumber;
    private Long whatsappNumber;
    private String address;
}
