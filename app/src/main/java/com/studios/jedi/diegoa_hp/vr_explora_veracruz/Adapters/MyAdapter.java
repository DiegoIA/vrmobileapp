package com.studios.jedi.diegoa_hp.vr_explora_veracruz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.studios.jedi.diegoa_hp.vr_explora_veracruz.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> ciudades;
    private int[] imagenes;

    //Metodo constructor
    public MyAdapter(Context context, int layout, List<String> ciudades, int[] imagenes){
        this.context = context;
        this.layout = layout;
        this.ciudades = ciudades;
        this.imagenes = imagenes;
    }


    @Override
    public int getCount() {
        return this.ciudades.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ciudades.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.list_item,null);

            holder = new ViewHolder();
            holder.cityTV = (TextView) convertView.findViewById(R.id.textView);
            holder.cityIV = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }

        String currentCity = ciudades.get(position);
        holder.cityTV.setText(currentCity);

        holder.cityIV.setBackgroundResource(imagenes[position]);

        return convertView;

    }

    static class ViewHolder{
        private TextView cityTV;
        private ImageView cityIV;
    }

}