package fr.leo.androidmonapplicationtest1.modele;

public class Personne {

    private String strNomPersonne;
    private String strPrenomPersonne;
    private String strSexePersonne;

    public Personne(String strSexePersonne, String strNomPersonne, String strPrenomPersonne) {
        super();
        this.strSexePersonne = strSexePersonne;
        this.strNomPersonne = strNomPersonne;
        this.strPrenomPersonne = strPrenomPersonne;
    }

    public Personne() {
        super();
    }

    public String getiSexePersonne() {
        return strSexePersonne;
    }

    public void setiSexePersonne(String strSexePersonne) {
        this.strSexePersonne = strSexePersonne;
    }

    public String getStrNomPersonne() {
        return strNomPersonne;
    }

    public void setStrNomPersonne(String strNomPersonne) {
        this.strNomPersonne = strNomPersonne;
    }

}