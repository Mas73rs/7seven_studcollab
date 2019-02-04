package cm.studio.devbee.exxamenfacile;

public class SchoolMatiereModel {
    public int imageMAtiere;
    public String nomMatiere;

    public SchoolMatiereModel(int imageMAtiere, String nomMatiere) {
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
    }
}
