package com.twise.modulessandbox.service;

import com.twise.modulessandbox.exception.AdditionalDocumentNotFoundException;
import com.twise.modulessandbox.mapper.AdditionalDocumentMapper;
import com.twise.modulessandbox.model.AdditionalDocument;
import com.twise.modulessandbox.model.AdditionalDocumentDto;
import com.twise.modulessandbox.repository.AdditionalDocumentCrudRepository;
import com.twise.modulessandbox.repository.AdditionalDocumentPagingAndSortingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdditionalDocumentService {

    private AdditionalDocumentCrudRepository additionalDocumentCrudRepository;
    private AdditionalDocumentPagingAndSortingRepository additionalDocumentPagingAndSortingRepository;
    private AdditionalDocumentMapper additionalDocumentMapper;

    public Page<AdditionalDocumentDto> getAllAdditionalDocuments(Pageable pageable) {
        return new PageImpl<>(additionalDocumentPagingAndSortingRepository
                .findAll(pageable)
                .stream()
                .map(additionalDocument -> additionalDocumentMapper.toDto(additionalDocument))
                .collect(Collectors.toList()));
    }

    public AdditionalDocumentDto getAdditionalDocument(Long id) {
        AdditionalDocument additionalDocument = additionalDocumentCrudRepository
                .findById(id)
                .orElseThrow(() -> new AdditionalDocumentNotFoundException(id));
        return additionalDocumentMapper.toDto(additionalDocument);
    }

    public AdditionalDocumentDto createAdditionalDocument(AdditionalDocumentDto additionalDocumentDto) {
        AdditionalDocument additionalDocument = additionalDocumentCrudRepository.save(additionalDocumentMapper.toDomain(additionalDocumentDto));
        return additionalDocumentMapper.toDto(additionalDocument);
    }

    public AdditionalDocumentDto updateAdditionalDocument(Long id, AdditionalDocumentDto inputAdditionalDocumentDto) {
        AdditionalDocument additionalDocument = additionalDocumentCrudRepository.findById(id).orElseGet(AdditionalDocument::new);
        additionalDocumentMapper.update(additionalDocument, inputAdditionalDocumentDto);
        additionalDocumentCrudRepository.save(additionalDocument);
        return additionalDocumentMapper.toDto(additionalDocument);
    }

    public void deleteAdditionalDocument(Long id) {
        additionalDocumentCrudRepository.deleteById(id);
    }
}
