package com.twise.modulessandbox.model;

import lombok.*;
import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "additional_document")
public class AdditionalDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String location;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "module_container_id", nullable = false)
    private ModuleContainer moduleContainer;
}
