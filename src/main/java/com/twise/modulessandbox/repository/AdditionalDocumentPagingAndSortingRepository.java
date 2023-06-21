package com.twise.modulessandbox.repository;

import com.twise.modulessandbox.model.AdditionalDocument;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalDocumentPagingAndSortingRepository extends PagingAndSortingRepository<AdditionalDocument, Long> {
}
