package test_inscriptio__desinscription;




import classes_principales.Concert;
import classes_principales.Evenement;
import classes_principales.Participant;
import exceptions.CapaciteMaxException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

class ParticipantTest {
    @Test
    void testInscriptionParticipant() throws CapaciteMaxException {
        Evenement evenement = new Concert("A1", "Concert_X-maleya","Yaounde", LocalDate.now(), 2550,"X-Maleya", "pop"  );
        Participant alice = new Participant("P1", "Alice", "alice@email.com");

        evenement.ajouterParticipant(alice);
        assertTrue(evenement.getParticipants().contains(alice), "Alice doit être inscrite !");
    }

    @Test
    void testDesinscriptionParticipant() throws CapaciteMaxException {
        Evenement evenement = new Concert("A1", "Concert_X-maleya","Yaounde", LocalDate.now(), 2550,"X-Maleya", "pop"  );
        Participant alice = new Participant("P1", "Alice", "alice@email.com");

        evenement.ajouterParticipant(alice);
        evenement.annuler(alice);

        assertFalse(evenement.getParticipants().contains(alice), "Bob ne doit plus être inscrit !");
    }
}
