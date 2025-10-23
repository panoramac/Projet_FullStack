package org.cours.springdatarest.service;

import org.cours.springdatarest.model.Voiture;
import org.cours.springdatarest.repository.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VoitureService {


    @Autowired
    private VoitureRepo repository;

    public Iterable<Voiture> getVoitures() {
        return repository.findAll();
    }

    // Vous ajouterez ici les méthodes pour POST, PUT, DELETE, etc.
}