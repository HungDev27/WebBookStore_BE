package com.hungjava.bookstore.utils;

import com.hungjava.bookstore.exception.ApiException;
import com.hungjava.bookstore.exception.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public class SecurityUtils {

    private SecurityUtils() {}

    // Lấy username của người dùng đang đăng nhập từ Security Context.
    public static String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ApiException(ErrorCode.UNAUTHORIZED);
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof Jwt jwt) {
            return jwt.getSubject();
        }
        return authentication.getName();
    }

    //Lấy userId của người dùng đang đăng nhập từ Security Context (trích xuất từ JWT claim "userId").
    //ApiException nếu chưa đăng nhập hoặc không tìm thấy userId trong token
    public static Integer getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new ApiException(ErrorCode.UNAUTHORIZED);
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof Jwt jwt) {
            Object userIdClaim = jwt.getClaim("userId");
            if (userIdClaim instanceof Number number) {
                return number.intValue();
            } else if (userIdClaim instanceof String str) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    throw new ApiException(ErrorCode.UNAUTHORIZED);
                }
            }
        }
        throw new ApiException(ErrorCode.UNAUTHORIZED);
    }
}
