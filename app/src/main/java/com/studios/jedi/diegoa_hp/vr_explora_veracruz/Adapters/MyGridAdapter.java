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

/**
 * Created by DiegoA-HP on 05/10/2017.
 */

public class MyGridAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private List<String> foodname;
    private int[] foodimag;

    //Metodo constructor
    public MyGridAdapter(Context context, int layout, List<String> foodname, int[] foodimag){
        this.context = context;
        this.layout = layout;
        this.foodname = foodname;
        this.foodimag = foodimag;
    }


    @Override
    public int getCount() {
        return this.foodname.size();
    }

    @Override
    public Object getItem(int position) {
        return this.foodname.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        MyGridAdapter.ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.grid_item,null);

            holder = new MyGridAdapter.ViewHolder();
            holder.foodTV = (TextView) convertView.findViewById(R.id.textView2);
            holder.foodIV = (ImageView) convertView.findViewById(R.id.imageView4);
            convertView.setTag(holder);
        }else{
            holder= (MyGridAdapter.ViewHolder) convertView.getTag();
        }

        String currentCity = foodname.get(position);
        //currentCity = (String) getItem(position);
        holder.foodTV.setText(currentCity);

        holder.foodIV.setImageResource(foodimag[position]);

        return convertView;

    }

    static class ViewHolder{
        private TextView foodTV;
        private ImageView foodIV;
    }

}
