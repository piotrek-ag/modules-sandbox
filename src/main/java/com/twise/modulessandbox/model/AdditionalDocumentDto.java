package com.twise.modulessandbox.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class AdditionalDocumentDto {
    private final String name;
    private final String location;
    private final ModuleContainerDto moduleContainer;
}
