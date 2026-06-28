package com.hungjava.bookstore.config;

import com.hungjava.bookstore.dto.security.IntrospectRequest;
import com.hungjava.bookstore.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CustomJwtDecoder implements JwtDecoder {

    AuthenticationService authenticationService; // Inject Service để gọi hàm kiểm tra

    @NonFinal
    @Value("${jwt.signerKey}")
    String SIGNER_KEY;

    @NonFinal
    NimbusJwtDecoder nimbusJwtDecoder;

    @Override
    public Jwt decode(String token) throws JwtException {
        // BƯỚC 1: Gọi logic từ Service kiểm tra xem token còn hợp lệ (chưa bị Logout) không
        if (!authenticationService.introspect(IntrospectRequest.builder()
                .token(token)
                .build()).isValid()) {
            throw new JwtException("Token không hợp lệ hoặc đã đăng xuất"); // Chặn luôn nếu nằm trong Blacklist
        }

        // BƯỚC 2: Nếu chưa khởi tạo NimbusDecoder thì tạo nó (Singleton pattern)
        if (nimbusJwtDecoder == null) {
            // Nạp khóa bí mật từ file properties
            SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
            nimbusJwtDecoder = NimbusJwtDecoder
                    .withSecretKey(secretKeySpec) // Khởi tạo với khóa bí mật
                    .macAlgorithm(MacAlgorithm.HS512) // Khởi tạo thuật toán HS512
                    .build();
        }

        // BƯỚC 3: Nếu token an toàn, đưa cho Nimbus tiến hành giải mã thành đối tượng Jwt cho Spring xử lý tiếp
        return nimbusJwtDecoder.decode(token);
    }
}