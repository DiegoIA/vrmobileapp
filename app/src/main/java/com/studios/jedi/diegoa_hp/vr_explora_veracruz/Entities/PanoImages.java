package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Entities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class PanoImages {
    private Integer identifier;
    private String data;
    private Bitmap image;

    public Integer getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Integer identifier) {
        this.identifier = identifier;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;

        try {
            byte[] byteCode = Base64.decode(data, Base64.DEFAULT);
            this.image = BitmapFactory.decodeByteArray(byteCode,0,byteCode.length);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
