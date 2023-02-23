package com.jeroenreijn.examples.repository;

import com.jeroenreijn.examples.model.Presentation;

public interface PresentationsRepository {
	Iterable<Presentation> findAll();
}
