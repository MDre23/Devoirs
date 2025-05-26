package test_esception;


import classes_principales.Concert;
import classes_principales.Participant;
import exceptions.CapaciteMaxException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class exceptionTest {

    @Test
    void testCapaciteMaxAtteinteException() {
        // 🔹 Création d’un événement avec capacité limitée
        Concert concert = new Concert("C1", "Rock Fest", "Berlin", LocalDate.of(2025, 5, 26), 2, "Imagine Dragons", "Rock");

        try {
            // 🔹 Ajout de deux participants (capacité max atteinte)
            concert.ajouterParticipant(new Participant("P1", "Alice", "alice@email.com"));
            concert.ajouterParticipant(new Participant("P2", "Bob", "bob@email.com"));

            // 🔹 Vérification que l'exception est bien levée pour un troisième ajout
            assertThrows(CapaciteMaxException.class, () -> {
                concert.ajouterParticipant(new Participant("P3", "Charlie", "charlie@email.com"));
            });

        } catch (CapaciteMaxException e) {
            fail(" L'exception ne devrait pas être levée avant le troisième ajout !");
        }
    }

    @Test
    void testAnnulationEvenement() {
        // 🔹 Création d’un événement
        Concert concert = new Concert("C1", "Rock Fest", "Berlin", LocalDate.of(2025, 5, 26), 5, "Imagine Dragons", "Rock");
        Participant alice = new Participant("P1", "Alice", "alice@email.com");

        try {
            concert.ajouterParticipant(alice);
            concert.annuler(alice);

            // 🔹 Vérification que le participant n'est plus inscrit
            assertFalse(concert.getParticipants().contains(alice), " Alice ne doit plus être inscrite après l’annulation !");
        } catch (CapaciteMaxException e) {
            fail(" L'exception ne devrait pas être levée ici.");
        }
    }
}
