package com.jeroenreijn.examples;

import com.jeroenreijn.examples.model.Presentation;

public interface PresentationsRepository {

    Iterable<Presentation> findAll();

    Presentation findPresentation(Long id);

}