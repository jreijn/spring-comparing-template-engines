package com.jeroenreijn.examples.repository;

import com.jeroenreijn.examples.model.Presentation;

import java.util.Optional;

public interface PresentationsRepository {
    Iterable<Presentation> findAll();

    Optional<Presentation> findById(Long id);
}