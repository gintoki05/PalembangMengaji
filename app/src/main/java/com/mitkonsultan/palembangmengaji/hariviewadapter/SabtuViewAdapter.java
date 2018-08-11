package com.mitkonsultan.palembangmengaji.hariviewadapter;

/**
 * Created by ajie on 27/09/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mitkonsultan.palembangmengaji.R;
import com.mitkonsultan.palembangmengaji.haridataadapter.SabtuDataAdapter;
import com.mitkonsultan.palembangmengaji.haridataadapter.SeninDataAdapter;

import java.util.ArrayList;

public class SabtuViewAdapter extends RecyclerView.Adapter<SabtuViewAdapter.DataObjectHolder>{

    private ArrayList<SabtuDataAdapter> mDataset;
    private Context context;

    public SabtuViewAdapter(ArrayList<SabtuDataAdapter> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_sabtu, parent, false);
        DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
        context = parent.getContext();
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(DataObjectHolder holder, int position) {

        holder.masjid.setText(mDataset.get(position).getMasjid());
        holder.waktu.setText(mDataset.get(position).getWaktu());
        holder.pengisi.setText(mDataset.get(position).getPengisi());
        holder.tema.setText(mDataset.get(position).getTema());
        holder.tanggal.setText(mDataset.get(position).getTanggal());
        holder.kategori.setText(mDataset.get(position).getKategori());


    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class DataObjectHolder extends RecyclerView.ViewHolder {

        TextView masjid, waktu, pengisi, tema, tanggal, kategori;
        ImageView image;

        public DataObjectHolder(View itemView) {
            super(itemView);

            masjid = (TextView) itemView.findViewById(R.id.sabtu1);
            waktu = (TextView) itemView.findViewById(R.id.sabtu2);
            pengisi = (TextView) itemView.findViewById(R.id.sabtu3);
            tema = (TextView) itemView.findViewById(R.id.sabtu4);
            tanggal = (TextView) itemView.findViewById(R.id.sabtu5);
            kategori = (TextView) itemView.findViewById(R.id.sabtu6);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}




