package classes_principales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Conference extends Evenement {
private String theme;
private List<Intervenant>intervenants= new ArrayList<>();

    public Conference(String id, String nom, String lieu, LocalDate date, int capaciteMax) {
        super(id, nom, lieu, date, capaciteMax);
    }

    public String getTheme() {return theme;}

    public void setTheme(String theme) {this.theme = theme;}
}
