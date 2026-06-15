package com.hungjava.bookstore.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.web.server.ResponseStatusException;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApiException extends ResponseStatusException {

    ErrorCode errorCode;

    public ApiException(ErrorCode errorCode) {
        super(errorCode.getStatus(), errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(ErrorCode errorCode, String customMessage) {
        super(errorCode.getStatus(), customMessage);
        this.errorCode = errorCode;
    }
}
