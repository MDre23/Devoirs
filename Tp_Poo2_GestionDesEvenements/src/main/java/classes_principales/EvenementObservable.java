package classes_principales;
import classes_principales.ParticipantObserver;

public interface EvenementObservable {
   void ajouterObserver(ParticipantObserver observer);
   void supprimerObserver(ParticipantObserver observer);
   void notifierObservers(String message);
}
