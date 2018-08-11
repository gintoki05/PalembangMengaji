package com.mitkonsultan.palembangmengaji.lokasi;

/**
 * Created by ajie on 24/09/17.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mitkonsultan.palembangmengaji.R;

import java.util.List;

public class LokasiListAdapter extends BaseAdapter {

    private LayoutInflater layoutinflater;
    private List<Lokasi> listStorage;
    private Context context;

    public LokasiListAdapter(Context context, List<Lokasi> customizedListView) {
        this.context = context;
        layoutinflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutinflater.inflate(R.layout.lokasi_list, parent, false);
            listViewHolder.gambar = (ImageView)convertView.findViewById(R.id.gambar);
            listViewHolder.nama = (TextView)convertView.findViewById(R.id.nama);
            listViewHolder.jalan = (TextView)convertView.findViewById(R.id.jalan);


            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.gambar.setImageResource(listStorage.get(position).getGambar());
        listViewHolder.nama.setText(listStorage.get(position).getNama());
        listViewHolder.jalan.setText(listStorage.get(position).getJalan());


        return convertView;
    }

    static class ViewHolder{
        ImageView gambar;
        TextView nama;
        TextView jalan;

    }

}

