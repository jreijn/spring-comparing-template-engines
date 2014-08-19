package com.jeroenreijn.examples;

import com.jeroenreijn.examples.model.Presentation;

import org.springframework.stereotype.Repository;

@Repository
public interface PresentationsRepository {

    Iterable<Presentation> findAll();

    Presentation findPresentation(Long id);

}