package cm.studio.devbee.exxamenfacile.util;

public class SchoolMatiereModel {
    //public int imageMAtiere;
    public String nomMatiere;
    public String titreExam;

    public SchoolMatiereModel(String nomMatiere, String titreExam) {
        this.nomMatiere = nomMatiere;
        this.titreExam = titreExam;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public String getTitreExam() {
        return titreExam;
    }

    public void setTitreExam(String titreExam) {
        this.titreExam = titreExam;
    }
    /* public SchoolMatiereModel(int imageMAtiere, String nomMatiere) {
        this.imageMAtiere = imageMAtiere;
        this.nomMatiere = nomMatiere;
    }

    public int getImageMAtiere() {
        return imageMAtiere;
    }

    public void setImageMAtiere(int imageMAtiere) {
        this.imageMAtiere = imageMAtiere;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }*/
}
