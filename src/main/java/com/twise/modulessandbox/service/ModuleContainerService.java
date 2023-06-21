package com.twise.modulessandbox.service;

import com.twise.modulessandbox.exception.ModuleContainerNotFoundException;
import com.twise.modulessandbox.mapper.ModuleContainerMapper;
import com.twise.modulessandbox.model.ModuleContainer;
import com.twise.modulessandbox.model.ModuleContainerDto;
import com.twise.modulessandbox.repository.ModuleContainerCrudRepository;
import com.twise.modulessandbox.repository.ModuleContainerPagingAndSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ModuleContainerService {

    private ModuleContainerCrudRepository moduleContainerCrudRepository;
    private ModuleContainerPagingAndSortingRepository moduleContainerPagingAndSortingRepository;
    private ModuleContainerMapper moduleContainerMapper;

    @Transactional(readOnly = true)
    public Page<ModuleContainerDto> getAllModuleContainers(Pageable pageable) {
        return new PageImpl<>(moduleContainerPagingAndSortingRepository
                .findAll(pageable)
                .stream()
                .map(moduleContainer -> moduleContainerMapper.toDto(moduleContainer))
                .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public ModuleContainerDto getModuleContainer(Long id) {
        ModuleContainer moduleContainer = moduleContainerCrudRepository
                .findById(id)
                .orElseThrow(() -> new ModuleContainerNotFoundException(id));
        return moduleContainerMapper.toDto(moduleContainer);
    }

    @Transactional
    public ModuleContainerDto createModuleContainer(ModuleContainerDto moduleContainerDto) {
        ModuleContainer moduleContainer = moduleContainerCrudRepository.save(moduleContainerMapper.toDomain(moduleContainerDto));
        return moduleContainerMapper.toDto(moduleContainer);
    }

    @Transactional
    public ModuleContainerDto updateModuleContainer(Long id, ModuleContainerDto inputModuleContainerDto) {
        ModuleContainer moduleContainer = moduleContainerCrudRepository.findById(id).orElseGet(ModuleContainer::new);
        moduleContainerMapper.update(moduleContainer, inputModuleContainerDto);
        moduleContainerCrudRepository.save(moduleContainer);
        return moduleContainerMapper.toDto(moduleContainer);
    }

    @Transactional
    public void deleteModuleContainer(Long id) {
        moduleContainerCrudRepository.deleteById(id);
    }
}
