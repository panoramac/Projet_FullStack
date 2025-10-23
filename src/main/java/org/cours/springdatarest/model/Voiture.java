package org.cours.springdatarest.model;

import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnore; // Importation nécessaire

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ToString(exclude = {"proprietaire"})
@EqualsAndHashCode(exclude = {"proprietaire"})
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String marque;
    private String modele;
    private String couleur;
    private String immatricule;
    private int annee;
    private double prix;

    // AJOUT DE @JsonIgnore pour casser la boucle lors de la sérialisation par le Controller
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "proprietaire_id")
    private Proprietaire proprietaire;

    // Constructeur sans l'ID
    public Voiture(String marque, String modele, String couleur,String immatricule, int annee, double prix, Proprietaire proprietaire) {
        this.marque = marque;
        this.modele = modele;
        this.couleur = couleur;
        this.immatricule = immatricule;
        this.annee = annee;
        this.prix = prix;
        this.proprietaire = proprietaire;
    }

    public Voiture(String marque, String modele, String couleur,String immatricule, int annee, double prix) {
        this(marque, modele, couleur,immatricule, annee, prix, null);
    }
}