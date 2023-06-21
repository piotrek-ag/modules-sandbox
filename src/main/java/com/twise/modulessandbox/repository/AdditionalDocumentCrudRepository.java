package com.twise.modulessandbox.repository;

import com.twise.modulessandbox.model.AdditionalDocument;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDocumentCrudRepository extends CrudRepository<AdditionalDocument, Long> {
}
