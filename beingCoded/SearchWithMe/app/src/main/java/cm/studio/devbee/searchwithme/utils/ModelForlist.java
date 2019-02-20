package cm.studio.devbee.searchwithme.utils;



public class ModelForlist {

 public String image_url,lieu,titre,user_description,user_id;

    public ModelForlist() {

    }
    public ModelForlist(String image_url, String lieu, String titre, String user_description, String user_id) {
        this.image_url = image_url;
        this.lieu = lieu;
        this.titre = titre;
        this.user_description = user_description;
        this.user_id = user_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getUser_description() {
        return user_description;
    }

    public void setUser_description(String user_description) {
        this.user_description = user_description;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
