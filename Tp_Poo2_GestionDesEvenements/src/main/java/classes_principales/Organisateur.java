package classes_principales;

import java.util.ArrayList;
import java.util.List;

public class Organisateur extends Participant{
private List<Evenement> evenements=new ArrayList<>();

    public Organisateur(String id, String nom, String email) {
        super(id, nom, email);
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
