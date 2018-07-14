package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters.MyGridAdapter;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

import java.util.ArrayList;
import java.util.List;

public class GastroViewActivity extends AppCompatActivity {

    private TextView textView;
    private GridView gridView;
    private List<String> comida;
    private String ciudad;

    private int[] imagenes;
         /**   R.drawable.fooda,
            R.drawable.foodb,
            R.drawable.foodc,
            R.drawable.foodd,
            R.drawable.foode,
            R.drawable.foodf,
            R.drawable.foodg,
            R.drawable.foodh,
            R.drawable.foodi,
            R.drawable.foodj
    };**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gastro_view);

        textView = (TextView) findViewById(R.id.textCView4);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("cityN2") != null ){
            String variable = bundle.getString("cityN2");
            textView.setText(variable);
            ciudad=variable;
        }

        //gridview <es un relajo!>
        gridView=(GridView) findViewById(R.id.gridView);

        comida = new ArrayList<String>();
        switch(ciudad) {
            case "Coatzacoalcos":
                comida.add("Carne Chinameca");
                comida.add("Memela");
                comida.add("Armadillo");
                comida.add("Taminilla");
                imagenes = new int[]{
                        R.drawable.fooda,
                        R.drawable.foodp,
                        R.drawable.foodm,
                        R.drawable.foodn
                };
                break;
            case "Minatitlan":
                comida.add("Bollito de Elote");
                comida.add("Tamal Chipil");
                comida.add("Camarón");
                comida.add("Pescado Seco");
                comida.add("Carne Chinameca");
                imagenes = new int[]{
                        R.drawable.foodk,
                        R.drawable.foodc,
                        R.drawable.foodl,
                        R.drawable.foodh,
                        R.drawable.foodo,
                        R.drawable.fooda,
                        R.drawable.foodg,
                        R.drawable.foodh,
                        R.drawable.foodi,
                        R.drawable.foodj
                };
                break;
            default:
                comida.add("No hay platillo disponible");
                imagenes = new int[]{
                  R.drawable.nofood
                };
                break;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,comida);

        gridView.setAdapter(adapter);

        //ListView onClickListener

        //Enlace con MyAdapter
        MyGridAdapter mygridAdapter = new MyGridAdapter (this, R.layout.grid_item, comida, imagenes);
        gridView.setAdapter(mygridAdapter);


    }
}
