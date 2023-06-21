package com.twise.modulessandbox.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class ModuleContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String moduleTemplate;
    private String finalModule;
    private String collaborationLink;

    @OneToMany(mappedBy = "additional_document", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AdditionalDocument> additionalDocuments = new ArrayList<>();
}
