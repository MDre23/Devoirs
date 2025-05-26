package classes_principales;


import actionJSON.actionJson;
import java.util.HashMap;
import java.util.Map;

public class GestionEvenements {
    private static GestionEvenements instance;
    private Map<Object, String> evenements=new HashMap<Object, String>();
    public static GestionEvenements getInstance(){
        if (instance==null){ instance= new GestionEvenements();}
        return instance;
}

public void ajouterEvenement(String id, String evenement){

        evenements.put(id, evenement);
    actionJson.sauvegarderListeEvenementEnJSON(evenements);

}
public void supprimerEvenement(String id){
        if ( evenements.containsKey(id)){
            evenements.remove(id);}
        else {

            System.out.println("evenement non existant");
        }
}

public String rechercherEvenement(String id){
       return evenements.getOrDefault(id, "evenement introuvable pour cet id.");
}
public void chargerEvenement(){
        actionJson.chargerListeEvenements();
   }


}