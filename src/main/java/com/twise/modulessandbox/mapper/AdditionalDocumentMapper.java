package com.twise.modulessandbox.mapper;

import com.twise.modulessandbox.model.AdditionalDocument;
import com.twise.modulessandbox.model.AdditionalDocumentDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AdditionalDocumentMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "moduleTemplate", target = "moduleTemplate"),
            @Mapping(source = "finalModule", target = "finalModule"),
            @Mapping(source = "collaborationLink", target = "collaborationLink"),
    })
    void update(AdditionalDocument target, AdditionalDocumentDto source);

    AdditionalDocumentDto toDto(AdditionalDocument additionalDocument);

    AdditionalDocument toDomain(AdditionalDocumentDto additionalDocumentDto);
}
