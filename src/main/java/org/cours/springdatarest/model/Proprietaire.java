package org.cours.springdatarest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ← AJOUTEZ CETTE LIGNE
public class Proprietaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String prenom;
    private String nom;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proprietaire")
    private List<Voiture> voitures;

    public Proprietaire(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }
}
