package com.twise.modulessandbox.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ModuleDto {
    private final String moduleTemplate;
    private final String finalModule;
    private final String collaborationLink;
}
