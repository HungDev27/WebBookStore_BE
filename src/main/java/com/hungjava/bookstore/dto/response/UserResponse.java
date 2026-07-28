package com.hungjava.bookstore.dto.response;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class UserResponse {
    String fullName;
    String username;
    String email;
    String avatar;
    String phone;
    List<String> roles;
}
