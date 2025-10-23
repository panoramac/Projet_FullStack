package org.cours.springdatarest;

import org.cours.springdatarest.model.Proprietaire;
import org.cours.springdatarest.model.Voiture;
import org.cours.springdatarest.repository.ProprietaireRepo;
import org.cours.springdatarest.repository.VoitureRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRestApplication.class, args);
    }

    // Injection des repositories
    @Bean
    public CommandLineRunner runner(VoitureRepo voitureRepository, ProprietaireRepo proprietaireRepository) {
        return args -> {
            // Vider les tables existantes pour éviter les doublons
            voitureRepository.deleteAll();
            proprietaireRepository.deleteAll();

            // 1. Créer des propriétaires
            Proprietaire proprietaire1 = new Proprietaire("John", "Doe");
            Proprietaire proprietaire2 = new Proprietaire("Mary", "Smith");

            // Sauvegarder les propriétaires
            proprietaireRepository.save(proprietaire1);
            proprietaireRepository.save(proprietaire2);

            // 2. Créer des voitures avec immatricule (comme dans le document)
            voitureRepository.save(new Voiture("Toyota", "Corolla", "Grise", "A-1-9090", 2018, 95000, proprietaire1));
            voitureRepository.save(new Voiture("Ford", "Fiesta", "Rouge", "A-2-8090", 2015, 90000, proprietaire1));
            voitureRepository.save(new Voiture("Honda", "CRV", "Bleu", "A-3-7090", 2016, 140000, proprietaire2));

            // Afficher le nombre de voitures pour vérifier
            System.out.println("Nombre de voitures en base : " + voitureRepository.count());

            // Afficher les voitures créées
            voitureRepository.findAll().forEach(voiture -> {
                System.out.println("Voiture: " + voiture.getMarque() + " " + voiture.getModele() +
                        " - Immatricule: " + voiture.getImmatricule());
            });
        };
    }
}
