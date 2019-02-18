package cm.studio.devbee.searchwithme.utils;

import java.sql.Timestamp;

public class Model {
    public String desc , image_url,lieu , titre , user_id;
    public Timestamp temp;
    public void Model(){}

    public Model(String desc, String lieu, String titre, String image_url, String user_id, Timestamp temp) {
        this.desc = desc;
        this.lieu = lieu;
        this.titre = titre;
        this.image_url = image_url;
        this.user_id = user_id;
        this.temp = temp;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public Timestamp getTemp() {
        return temp;
    }

    public void setTemp(Timestamp temp) {
        this.temp = temp;
    }
}
