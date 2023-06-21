package com.twise.modulessandbox.controller;

import com.twise.modulessandbox.service.ModuleManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/modules/manager")
public class ModuleManagerController {

    private ModuleManagerService moduleManagerService;

    @GetMapping()
    public List<String> getModules(@RequestParam(value = "caseDetails", required = true) String caseDetails,
                                   @RequestParam(value = "caseType", required = true) String caseType) {
        return moduleManagerService.getModuleNames(caseDetails, caseType);
    }
}

