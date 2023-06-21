package com.twise.modulessandbox.mapper;

import com.twise.modulessandbox.model.ModuleContainer;
import com.twise.modulessandbox.model.ModuleContainerDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ModuleContainerMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "moduleTemplate", target = "moduleTemplate"),
            @Mapping(source = "finalModule", target = "finalModule"),
            @Mapping(source = "collaborationLink", target = "collaborationLink"),
    })
    void update(@MappingTarget ModuleContainer target, ModuleContainerDto source);

    ModuleContainerDto toDto(ModuleContainer moduleContainer);

    ModuleContainer toDomain(ModuleContainerDto moduleContainerDto);
}
