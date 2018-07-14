package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

public class EventoViewActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento_view);

        textView = (TextView) findViewById(R.id.textCView5);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("cityN2") != null ){
            String variable = bundle.getString("cityN2");
            textView.setText(variable);
        }
    }
}
