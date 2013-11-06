package com.jeroenreijn.examples.services;

import com.jeroenreijn.examples.PresentationsRepository;
import com.jeroenreijn.examples.model.Presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Simple service for fetching presentations.
 * @author Jeroen Reijn
 */
@Service
public class PresentationsService {

    @Autowired
    PresentationsRepository presentationsRepository;

    public Iterable<Presentation> findAll() {
        return this.presentationsRepository.findAll();
    }

}
