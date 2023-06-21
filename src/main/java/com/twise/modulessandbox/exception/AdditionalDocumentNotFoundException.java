package com.twise.modulessandbox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AdditionalDocumentNotFoundException extends RuntimeException {
    public AdditionalDocumentNotFoundException(Long id) {
        super("Could not find AdditionalDocument with id " + id);
    }
}
