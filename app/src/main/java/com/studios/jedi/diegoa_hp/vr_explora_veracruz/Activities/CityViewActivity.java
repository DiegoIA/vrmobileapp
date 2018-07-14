package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.MapCViewActivity;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

public class CityViewActivity extends AppCompatActivity {

    private TextView textView;

    private ImageButton ecobtn;
    private ImageButton acercabtn;
    private ImageButton ubicabtn;
    private ImageButton gastrobtn;
    private ImageButton eventobtn;

    private String cityName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_view);

        textView = (TextView) findViewById(R.id.textCityView);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("cityN") != null ){
            String variable = bundle.getString("cityN");
            textView.setText(variable);
            cityName = bundle.getString("cityN");
        }

        //declaracion de botones
        ecobtn=(ImageButton) findViewById(R.id.ecobtn);
        acercabtn=(ImageButton) findViewById(R.id.acercabtn);
        ubicabtn=(ImageButton) findViewById(R.id.ubicabtn);
        gastrobtn=(ImageButton) findViewById(R.id.gastrobtn);
        eventobtn=(ImageButton) findViewById(R.id.eventobtn);

        //clic de los botones
        ecobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityViewActivity.this, EcoViewActivity.class);
                //intent.putExtra("cityN2",cityName);
                startActivity(intent);
            }
        });

        acercabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CityViewActivity.this, AboutViewActivity.class);
                intent.putExtra("cityN2",cityName);
                startActivity(intent);
            }
        });

        ubicabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityViewActivity.this, MapCViewActivity.class);
                intent.putExtra("cityN2",cityName);
                startActivity(intent);
            }
        });

        gastrobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityViewActivity.this, GastroViewActivity.class);
                intent.putExtra("cityN2",cityName);
                startActivity(intent);
            }
        });

        eventobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CityViewActivity.this, EventoViewActivity.class);
                intent.putExtra("cityN2",cityName);
                startActivity(intent);
            }
        });

    }
}
