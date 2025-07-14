package com.fitlytic.backend.dto;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String password;
    private String email; // only used for registration
}
