package com.twise.modulessandbox.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
public class ModuleContainerDto {
    private final String moduleTemplate;
    private final String finalModule;
    private final String collaborationLink;
    private final List<AdditionalDocumentDto> additionalDocuments;
}
