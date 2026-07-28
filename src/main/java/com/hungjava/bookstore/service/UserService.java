package com.hungjava.bookstore.service;

import com.hungjava.bookstore.dto.response.UserResponse;
import com.hungjava.bookstore.entity.User;

public interface UserService {
    User findByUsername(String username);
    UserResponse getMyProfile();
}

