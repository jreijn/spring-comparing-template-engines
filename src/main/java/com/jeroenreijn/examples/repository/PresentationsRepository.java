package com.jeroenreijn.examples.repository;

import java.util.Optional;

import com.jeroenreijn.examples.model.Presentation;

public interface PresentationsRepository {
	Iterable<Presentation> findAll();

	Optional<Presentation> findById(Long id);
}