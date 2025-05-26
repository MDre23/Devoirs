package classes_principales;


import exceptions.CapaciteMaxException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Evenement implements EvenementObservable {
protected String id, nom,lieu ;
protected LocalDate date;
protected int capaciteMax;
protected List<Participant> Participants= new ArrayList<>();
    private List<ParticipantObserver> abonnEs = new ArrayList<>();


    /* ***********************CONSTRUCTEUR*************************************** */

    public Evenement(String id,String nom, String lieu, LocalDate date, int capaciteMax){
        this.id=id;
        this.nom=nom;
        this.lieu=lieu;
        this.date=date;
        this.capaciteMax=capaciteMax;

    }




public void ajouterParticipant(Participant participant) throws CapaciteMaxException {
    if (Participants.size()>=capaciteMax){
        throw new CapaciteMaxException("la capacité max"+"("+capaciteMax+")"+"est atteinte et l'élement"+nom+"ne peut être ajouté");
    }
    Participants.add(participant);

    }


public void annuler(Participant participant){
    Participants.remove(participant);

    notifierObservers("Desolé mais l'evenement a été annulé");

}

public void afficherDetails(){

}

    @Override
    public void ajouterObserver(ParticipantObserver observer) {
        abonnEs.add(observer);
    }

    @Override
    public void supprimerObserver(ParticipantObserver observer) {
        abonnEs.remove(observer);
    }

    @Override
    public void notifierObservers(String message) {
        for (ParticipantObserver abonné : abonnEs) {
            abonné.notifier(message);
        }
    }
    public String getNom() { return nom;}
    public void setNom(String nom){this.nom=nom;}

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public LocalDate getDate() {return date;}

    public void setDate(LocalDate date) {this.date = date;}

    public String getLieu() {return lieu;}

    public void setLieu(String lieu) {this.lieu = lieu;}

    public int getCapaciteMax(){return capaciteMax;}

    public void setCapaciteMax(int capaciteMax) {this.capaciteMax = capaciteMax;}

    public List<Participant> getParticipants() {return Participants;}

    public void setParticipants(List<Participant> participants) {
        Participants = participants;
    }
}

