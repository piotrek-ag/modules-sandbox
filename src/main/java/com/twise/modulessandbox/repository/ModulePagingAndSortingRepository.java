package com.twise.modulessandbox.repository;


import com.twise.modulessandbox.model.ModuleInstance;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ModulePagingAndSortingRepository extends PagingAndSortingRepository<ModuleInstance, Long> {
}
