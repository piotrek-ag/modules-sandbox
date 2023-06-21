package com.twise.modulessandbox.controller;

import com.twise.modulessandbox.model.ModuleDto;
import com.twise.modulessandbox.service.ModuleInstanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/modules/instances")
public class ModuleInstanceController {

    private ModuleInstanceService moduleInstanceService;

    @GetMapping
    public Page<ModuleDto> getAllModules(final @PageableDefault(size = 5) Pageable pageable) {
        return moduleInstanceService.getAllModules(pageable);
    }

    @GetMapping("/{id}")
    public ModuleDto getModule(@PathVariable Long id) {
        return moduleInstanceService.getModule(id);
    }

    @PostMapping
    public ModuleDto createModule(@RequestBody ModuleDto moduleDto) {
        return moduleInstanceService.createModule(moduleDto);
    }

    @PutMapping("/{id}")
    public ModuleDto updateModule(@PathVariable Long id, @RequestBody ModuleDto moduleDto) {
        return moduleInstanceService.updateModule(id, moduleDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        moduleInstanceService.deleteModule(id);
        return ResponseEntity.noContent().build();
    }
}

