package com.twise.modulessandbox.service;

import com.twise.modulessandbox.mapper.ModuleMapper;
import com.twise.modulessandbox.model.ModuleInstance;
import com.twise.modulessandbox.model.ModuleDto;
import com.twise.modulessandbox.repository.ModuleCrudRepository;
import com.twise.modulessandbox.repository.ModulePagingAndSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ModuleInstanceService {

    private ModulePagingAndSortingRepository modulePagingAndSortingRepository;
    private ModuleCrudRepository moduleCrudRepository;
    private ModuleMapper moduleMapper;

    public Page<ModuleDto> getAllModules(Pageable pageable) {
        return new PageImpl<>(modulePagingAndSortingRepository
                .findAll(pageable)
                .stream()
                .map(module -> moduleMapper.toDto(module))
                .collect(Collectors.toList()));
    }

    public ModuleDto getModule(Long id) {
        ModuleInstance moduleInstance = moduleCrudRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(""));
        return moduleMapper.toDto(moduleInstance);
    }

    public ModuleDto createModule(ModuleDto moduleDto) {
        ModuleInstance moduleInstance = moduleCrudRepository.save(moduleMapper.toDomain(moduleDto));
        return moduleMapper.toDto(moduleInstance);
    }

    public ModuleDto updateModule(Long id, ModuleDto inputModuleDto) {
        ModuleInstance moduleInstance = moduleCrudRepository.findById(id).orElseGet(ModuleInstance::new);
        moduleMapper.update(moduleInstance, inputModuleDto);
        moduleCrudRepository.save(moduleInstance);
        return moduleMapper.toDto(moduleInstance);
    }

    public void deleteModule(Long id) {
        moduleCrudRepository.deleteById(id);
    }
}
