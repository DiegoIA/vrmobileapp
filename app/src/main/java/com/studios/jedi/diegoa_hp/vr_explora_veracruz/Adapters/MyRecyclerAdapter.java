package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities.MainActivity;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.Activities.PanoViewActivity;
import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

import java.util.List;

/**
 * Created by DiegoA-HP on 28/10/2017.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<EcoPlace> ecoPlaces;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Context context;
    private String cityName = "Coatzacoalcos";

    public MyRecyclerAdapter (List<EcoPlace> ecoPlaces, int layout, OnItemClickListener listener){
        this.ecoPlaces = ecoPlaces;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        context=parent.getContext();
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(ecoPlaces.get(position), itemClickListener);
        holder.setOnClickListeners();
    }

    @Override
    public int getItemCount() {
        return ecoPlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewName;
        public ImageView imageViewEP;
        public ImageButton gpsButton;
        public ImageButton panoButton;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textView5);
            this.imageViewEP = (ImageView) itemView.findViewById(R.id.imageView5);
            this.gpsButton = (ImageButton) itemView.findViewById(R.id.imageButton2);
            this.panoButton = (ImageButton) itemView.findViewById(R.id.imageButton);

        }


        public void bind(final EcoPlace ecoPlace, final OnItemClickListener listener){

            textViewName.setText(ecoPlace.getName());
            //imageViewEP.setImageResource(ecoPlace.getImage());
            Picasso.with(context).load(ecoPlace.getImage()).fit().into(imageViewEP);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(ecoPlace, getAdapterPosition());

                }
            });
        }
        void setOnClickListeners(){
            gpsButton.setOnClickListener(this);
            panoButton.setOnClickListener(this);
        }
        @Override
        public void onClick(View x) {
            switch (x.getId()){
                case R.id.imageButton: //panoButton
                    Intent intent = new Intent(context, PanoViewActivity.class);
                    if(textViewName.getText()=="Barrillas") {
                        intent.putExtra("cityPV", "andes");
                    }else{
                        if(textViewName.getText()=="Jicacal"){
                            intent.putExtra("cityPV", "pruebaa");
                        }
                    }
                    context.startActivity(intent);

                    break;
                case  R.id.imageButton2: //gpsButton
                    Intent intent2 = new Intent(context, MainActivity.class);
                    context.startActivity(intent2);

                    break;
                default:
                    break;
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(EcoPlace ecoPlace, int position);
    }

}
