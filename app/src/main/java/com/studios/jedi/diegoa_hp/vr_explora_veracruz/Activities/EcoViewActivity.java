package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters.MyRecyclerAdapter;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters.EcoPlace;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

import java.util.ArrayList;
import java.util.List;

public class EcoViewActivity extends AppCompatActivity {

    private List<EcoPlace> ecoPlaces;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eco_view);

        ecoPlaces = this.getAllEcoPlaces();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);

        mAdapter = new MyRecyclerAdapter(ecoPlaces, R.layout.reclycer_item, new MyRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(EcoPlace ecoPlace, int position) {
                Toast.makeText(EcoViewActivity.this, ecoPlace + " " + position, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);

    }

    private List<EcoPlace> getAllEcoPlaces(){
        return new ArrayList<EcoPlace>(){{
            add(new EcoPlace(("Barrillas"), R.drawable.barrillas));
            add(new EcoPlace(("Jicacal"), R.drawable.aguadulist));

        }};
    }

}
