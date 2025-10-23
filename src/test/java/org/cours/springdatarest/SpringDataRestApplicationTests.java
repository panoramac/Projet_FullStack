package org.cours.springdatarest;


import static org.assertj.core.api.Assertions.assertThat;

import org.cours.springdatarest.controller.VoitureController;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @RunWith(SpringRunner.class) est obsolète avec JUnit 5 (jupiter)
// Mais si votre environnement l'exige, gardez-le.
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringDataRestApplicationTests {

    @Autowired
    VoitureController voitureController;

    @Test
    void contextLoads() {
        // Teste si l’instance du contrôleur a été créé et injectée avec succès (n'est pas null).
        assertThat(voitureController).isNotNull();
    }
}
