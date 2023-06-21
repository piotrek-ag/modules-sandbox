package com.twise.modulessandbox.repository;


import com.twise.modulessandbox.model.ModuleInstance;
import org.springframework.data.repository.CrudRepository;

public interface ModuleCrudRepository extends CrudRepository<ModuleInstance, Long> {
}
