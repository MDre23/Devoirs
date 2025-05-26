package classes_principales;

public class Intervenant extends Participant{

    public String domaine_D_expertise;
    public Intervenant(String id, String nom, String email,String domaine_D_expertise) {
        super(id, nom, email);
        this.domaine_D_expertise=domaine_D_expertise;
    }
}
