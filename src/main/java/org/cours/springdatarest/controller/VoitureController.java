package org.cours.springdatarest.controller;

import org.cours.springdatarest.model.Voiture;
import org.cours.springdatarest.repository.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/voitures")
@CrossOrigin(origins = "http://localhost:3000")
public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;

    @GetMapping
    public Iterable<Voiture> getVoitures() {
        return voitureRepo.findAll();
    }

    // AJOUTEZ CES MÉTHODES
    @PostMapping
    public ResponseEntity<Voiture> createVoiture(@RequestBody Voiture voiture) {
        try {
            System.out.println("Création voiture via contrôleur personnalisé: " + voiture);
            Voiture savedVoiture = voitureRepo.save(voiture);
            return ResponseEntity.ok(savedVoiture);
        } catch (Exception e) {
            System.out.println("Erreur création: " + e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        try {
            if (voitureRepo.existsById(id)) {
                voitureRepo.deleteById(id);
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}