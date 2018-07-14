package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters.MyAdapter;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView listView;
    private List<String> ciudades;
    private String cityName="";
    private int[] imagenes ={
            R.drawable.coatzalist,
            R.drawable.minalist,
            R.drawable.pajapanlist,
            R.drawable.cosolealist,
            R.drawable.acayucanlist,
            R.drawable.aguadulist,
            R.drawable.coatzalist,
            R.drawable.coatzalist,
            R.drawable.coatzalist,
            R.drawable.coatzalist,
            R.drawable.coatzalist
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listView);

        ciudades = new ArrayList<String>();
        ciudades.add("Coatzacoalcos");
        ciudades.add("Minatitlan");
        ciudades.add("Pajapan");
        ciudades.add("Cosoleacaque");
        ciudades.add("Acayucan");
        ciudades.add("Agua Dulce");
        ciudades.add("Nanchital");
        ciudades.add("Las Choapas");
        ciudades.add("Jaltipan");
        ciudades.add("Texistepec");
        ciudades.add("Soconusco");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ciudades);

        listView.setAdapter(adapter);

        //ListView onClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,CityViewActivity.class);
                cityName = (listView.getItemAtPosition(position)).toString();
                intent.putExtra("cityN", cityName);
                startActivity(intent);
            }
        });

        //Enlace con MyAdapter
        MyAdapter myAdapter = new MyAdapter (this, R.layout.list_item, ciudades, imagenes);
        listView.setAdapter(myAdapter);

    }

}
