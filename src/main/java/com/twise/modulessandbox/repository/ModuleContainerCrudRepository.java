package com.twise.modulessandbox.repository;


import com.twise.modulessandbox.model.ModuleContainer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleContainerCrudRepository extends CrudRepository<ModuleContainer, Long> {
}
