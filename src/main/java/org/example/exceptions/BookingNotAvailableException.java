package org.example.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class BookingNotAvailableException extends RuntimeException {
    public BookingNotAvailableException (String message){
        super(message);
    }
}
