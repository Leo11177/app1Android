package fr.leo.androidmonapplicationtest1.controleur;

import fr.leo.androidmonapplicationtest1.modele.Personne;

public class Controleur {

    private static Controleur monInstance = null;
    private Personne  maPersonne;

    private Controleur() {
        super();
    }

    public static final Controleur getMonInstance() {
        if(monInstance ==null){
            Controleur.monInstance = new Controleur();
        }
        return monInstance;
    }

    public void creerPersonne(String strSexe, String strNom, String strPrenom){
       maPersonne  =new Personne(strSexe, strNom,strPrenom);
    }

    public Personne getMaPersonne() {
        return maPersonne;
    }
}
