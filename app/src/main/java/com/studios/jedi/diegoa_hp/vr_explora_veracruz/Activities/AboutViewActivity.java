package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

public class AboutViewActivity extends AppCompatActivity {

    private TextView textView;
    private TextView tV;
    private TextView tV2;

    private ImageView imageView;
    private ImageView imageView2;

    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_view);

        textView = (TextView) findViewById(R.id.textCView2);
        tV = (TextView) findViewById(R.id.textView3);
        tV2 = (TextView) findViewById(R.id.textView4);
        imageView = (ImageView) findViewById(R.id.imageView2);
        imageView2 = (ImageView) findViewById(R.id.imageView3);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("cityN2") != null ){
            String variable = bundle.getString("cityN2");
            cityName=bundle.getString("cityN2");
            textView.setText(variable);
        }

        //intento de agregar texto de acuerdo a la ciudad
        switch (cityName){
            case "Coatzacoalcos":
                imageView.setImageResource(R.drawable.escudocoatza);
                tV.setText(R.string.coatza1);
                imageView2.setImageResource(R.drawable.coatzaa);
                tV2.setText(R.string.coatza2);
                break;
            case "Minatitlan":
                imageView.setImageResource(R.drawable.escudomina);
                tV.setText(R.string.mina1);
                imageView2.setImageResource(R.drawable.minaa);
                tV2.setText(R.string.mina2);
                break;
            case "Pajapan":
                imageView.setImageResource(R.drawable.escudoveracruz);
                tV.setText(R.string.pajapan1);
                imageView2.setImageResource(R.drawable.pajapanlist);
                tV2.setText(" ");
                break;
            default:
                imageView.setImageResource(R.drawable.escudoveracruz);
                tV.setText(" ");
                imageView2.setImageResource(R.color.colorPrimaryDark);
                tV2.setText(" ");
                break;
        }


    }
}
