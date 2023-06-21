package com.twise.modulessandbox.model;

import lombok.*;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "module_instance")
public class ModuleInstance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String moduleTemplate;
    private String finalModule;
    private String collaborationLink;
}
