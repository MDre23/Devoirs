package actionJSON;
import classes_principales.Evenement;
import classes_principales.GestionEvenements;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class actionJson {
    private static final String FICHIER_JSON = "evenements.json";

    public static void sauvegarderListeEvenementEnJSON(Map<Object, String> evenements){
        ObjectMapper objectMapper= new ObjectMapper();
        try{
            objectMapper.writeValue(new File(FICHIER_JSON), evenements);
            System.out.println("liste bien sauvegarder"+FICHIER_JSON);

    } catch (IOException e) {
            System.out.println("Erreur de sauvegarde"+e);
        }

    }

    public static List<Evenement> chargerListeEvenements() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File fichier = new File(FICHIER_JSON);
            if (fichier.exists()) {
                CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Evenement.class);
                List<Evenement> evenements = objectMapper.readValue(fichier, type);
                System.out.println("Liste des événements chargée depuis JSON.");
                return evenements;
            } else {
                System.out.println("Aucun fichier JSON trouvé. Retour d'une liste vide.");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement JSON : " + e.getMessage());
        }
        return List.of(); // Retourne une liste vide si erreur
    }




    }
