package com.twise.modulessandbox.controller;

import com.twise.modulessandbox.model.ModuleContainerDto;
import com.twise.modulessandbox.service.ModuleContainerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/module-containers")
public class ModuleContainerController {
    private static final String ID = "/{id:[0-9]+}";

    private ModuleContainerService moduleContainerService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<ModuleContainerDto> getAllContainers(final @PageableDefault(size = 5) Pageable pageable) {
        return moduleContainerService.getAllModuleContainers(pageable);
    }

    @GetMapping(value = ID, produces = APPLICATION_JSON_VALUE)
    public ModuleContainerDto getModule(@PathVariable Long id) {
        return moduleContainerService.getModuleContainer(id);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ModuleContainerDto createModule(@RequestBody @Valid ModuleContainerDto moduleContainerDto) {
        return moduleContainerService.createModuleContainer(moduleContainerDto);
    }

    @PutMapping(value = ID, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ModuleContainerDto updateModule(@PathVariable("id") Long id, @RequestBody ModuleContainerDto moduleContainerDto) {
        return moduleContainerService.updateModuleContainer(id, moduleContainerDto);
    }

    @DeleteMapping(value = ID, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteModule(@PathVariable("id") Long id) {
        try {
            moduleContainerService.deleteModuleContainer(id);
        } catch (EmptyResultDataAccessException ex) {
            log.info("No ModuleContainer with id {} found", id);
        }
    }
}
