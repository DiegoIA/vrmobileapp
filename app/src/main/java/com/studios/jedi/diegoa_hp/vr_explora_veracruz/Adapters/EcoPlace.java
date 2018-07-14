package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters;

/**
 * Created by DiegoA-HP on 01/11/2017.
 */

public class EcoPlace {

    public String name;
    public int image;

    public EcoPlace() {

    }

    public EcoPlace(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
