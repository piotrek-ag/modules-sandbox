package com.twise.modulessandbox.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModuleContainerNotFoundException extends RuntimeException {
    public ModuleContainerNotFoundException(Long id) {
        super("Could not find ModuleContainer with id " + id);
    }
}
