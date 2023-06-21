package com.twise.modulessandbox.repository;


import com.twise.modulessandbox.model.ModuleContainer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleContainerPagingAndSortingRepository extends PagingAndSortingRepository<ModuleContainer, Long> {
}
