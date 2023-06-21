package com.twise.modulessandbox.controller;

import com.twise.modulessandbox.model.AdditionalDocumentDto;
import com.twise.modulessandbox.service.AdditionalDocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/additional-documents")
public class AdditionalDocumentController {
    private static final String ID = "/{id:[0-9]+}";

    private AdditionalDocumentService additionalDocumentService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public Page<AdditionalDocumentDto> getAllAdditionalDocuments(final @PageableDefault(size = 5) Pageable pageable) {
        return additionalDocumentService.getAllAdditionalDocuments(pageable);
    }

    @GetMapping(value = ID, produces = APPLICATION_JSON_VALUE)
    public AdditionalDocumentDto getAdditionalDocument(@PathVariable Long id) {
        return additionalDocumentService.getAdditionalDocument(id);
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public AdditionalDocumentDto createAdditionalDocument(@RequestBody @Valid AdditionalDocumentDto additionalDocumentDto) {
        return additionalDocumentService.createAdditionalDocument(additionalDocumentDto);
    }

    @PutMapping(value = ID, produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public AdditionalDocumentDto updateAdditionalDocument(@PathVariable("id") Long id, @RequestBody AdditionalDocumentDto additionalDocumentDto) {
        return additionalDocumentService.updateAdditionalDocument(id, additionalDocumentDto);
    }

    @DeleteMapping(value = ID, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdditionalDocument(@PathVariable("id") Long id) {
        try {
            additionalDocumentService.deleteAdditionalDocument(id);
        } catch (EmptyResultDataAccessException ex) {
            log.info("No AdditionalDocument with id {} found", id);
        }
    }
}
