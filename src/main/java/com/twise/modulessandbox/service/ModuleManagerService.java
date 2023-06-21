package com.twise.modulessandbox.service;

import com.twise.modulessandbox.repository.ModulePagingAndSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ModuleManagerService {

    private ModulePagingAndSortingRepository modulePagingAndSortingRepository;

    public List<String> getModuleNames(String caseDetails, String caseType) {
        return Collections.emptyList();
    }
}
