package classes_principales;

import java.time.LocalDate;

public class Concert extends Evenement{
private String artiste;
private String genreMusicale;

    public Concert(String id, String nom, String lieu, LocalDate date, int capaciteMax, String artiste, String genreMusicale) {
        super(id, nom, lieu, date, capaciteMax);
        this.artiste=artiste;
        this.genreMusicale=genreMusicale;

    }
    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }
    public String getGenreMusicale() { return genreMusicale;}
    public void setGenreMusicale(String genreMusicale){ this.genreMusicale=genreMusicale;}

}
