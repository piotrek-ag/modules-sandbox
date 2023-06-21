package com.twise.modulessandbox.mapper;

import com.twise.modulessandbox.model.ModuleInstance;
import com.twise.modulessandbox.model.ModuleDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ModuleMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "moduleTemplate", target = "moduleTemplate"),
            @Mapping(source = "finalModule", target = "finalModule"),
            @Mapping(source = "collaborationLink", target = "collaborationLink"),
    })
    void update(@MappingTarget ModuleInstance target, ModuleDto source);

    ModuleDto toDto(ModuleInstance moduleInstance);

    ModuleInstance toDomain(ModuleDto moduleDto);
}
