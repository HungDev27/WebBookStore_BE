package com.hungjava.bookstore.controller;

import com.hungjava.bookstore.dto.ApiResponse;
import com.hungjava.bookstore.dto.response.UserResponse;
import com.hungjava.bookstore.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("${api.prefix}/users")
public class UserController {

    UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<ApiResponse<UserResponse>> getMyProfile() {
        return ResponseEntity.ok(ApiResponse.<UserResponse>builder()
                .success(true)
                .data(userService.getMyProfile())
                .build());
    }
}
