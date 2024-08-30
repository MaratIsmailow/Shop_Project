package ait.shop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "This ia Second Test Exception")
public class SecondTestException extends RuntimeException{
    public SecondTestException(String message) {
        super(message);
    }
}
