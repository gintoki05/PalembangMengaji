package com.mitkonsultan.palembangmengaji.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.mitkonsultan.palembangmengaji.R;
import com.mitkonsultan.palembangmengaji.lokasi.Lokasi;
import com.mitkonsultan.palembangmengaji.lokasi.LokasiListAdapter;
import com.mitkonsultan.palembangmengaji.map.KediamanUA;
import com.mitkonsultan.palembangmengaji.map.MasjidAlhidayah;
import com.mitkonsultan.palembangmengaji.map.MasjidAssudais;
import com.mitkonsultan.palembangmengaji.map.MasjidBakti;
import com.mitkonsultan.palembangmengaji.map.MasjidDarulAsykar;
import com.mitkonsultan.palembangmengaji.map.MasjidFirqotun;
import com.mitkonsultan.palembangmengaji.map.MasjidImamSyafii;
import com.mitkonsultan.palembangmengaji.map.MasjidSabilulMuhtadin;
import com.mitkonsultan.palembangmengaji.map.Mazada;
import com.mitkonsultan.palembangmengaji.map.MusallaDarussalam;

import java.util.ArrayList;
import java.util.List;

public class FragmentTiga extends Fragment {

    public FragmentTiga() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_tiga, container, false);
        GridView gridview = (GridView)view.findViewById(R.id.gridview);

        List<Lokasi> allLokasi = getAllLokasi();
        LokasiListAdapter customAdapter = new LokasiListAdapter(getActivity(), allLokasi);
        gridview.setAdapter(customAdapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidBakti.class);
                    context.startActivity(intent);
                }
                else if (position == 1) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidImamSyafii.class);
                    context.startActivity(intent);
                }
                else if (position == 2) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, Mazada.class);
                    context.startActivity(intent);
                }
                else if (position == 3) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidFirqotun.class);
                    context.startActivity(intent);
                }
                else if (position == 4) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MusallaDarussalam.class);
                    context.startActivity(intent);
                }
                else if (position == 5) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidAlhidayah.class);
                    context.startActivity(intent);
                }
                else if (position == 6) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidAssudais.class);
                    context.startActivity(intent);
                }
                else if (position == 7) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidSabilulMuhtadin.class);
                    context.startActivity(intent);
                }
                else if (position == 8) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, MasjidDarulAsykar.class);
                    context.startActivity(intent);
                }
                else if (position == 9) {
                    Context context = view.getContext();
                    Intent intent = new Intent(context, KediamanUA.class);
                    context.startActivity(intent);
                }
            }
        });
        return view;
    }

    private List<Lokasi> getAllLokasi(){
        List<Lokasi> items = new ArrayList<>();
        items.add(new Lokasi(R.drawable.masjidbakti,"Masjid Bakti","Jl. Sukabakti, seberang Graha Sumeks, sebelum Punti Kayu, KM. 6"));
        items.add(new Lokasi(R.drawable.mias,"Masjid Imam Syafii","PPTQ Mutiara Sunnah, Jl. Pertahanan, sebelum Giant, dekat SMA N 8, Plaju"));
        items.add(new Lokasi(R.drawable.mazada,"Masjid Sulaiman Al-Kuraida","Ponpes Zaadul Ma'ad, Jl. Padat Karya, Lrg. Melati, Sugiwaras, Talang Jambe"));
        items.add(new Lokasi(R.drawable.masjid,"Masjid Firqotun Najiyah","Perumahan Pondok Palem Indah, dekat Grant City, T.Kelapa, Alang-Alang Lebar"));
        items.add(new Lokasi(R.drawable.masjid,"Musalla Darussalam","Jl. May Zen, Lrg. Cendana, depan Bank Mandiri PT. Pusri"));
        items.add(new Lokasi(R.drawable.masjidalhidayah,"Masjid Al-Hidayah","Jl. Lunjuk Jaya, jalan di samping kiri Universitas Sriwijaya, Bukit"));
        items.add(new Lokasi(R.drawable.masjid,"Masjid As-Sudais","Jl. Lintas Barat, Sukabangun II, Sukajaya, KM. 6"));
        items.add(new Lokasi(R.drawable.masjid,"Masjid Sabilul Muhtadin","Jl. Lebak Murni, setelah SMA N 16, Sako"));
        items.add(new Lokasi(R.drawable.masjid,"Masjid Darul Asykar","Kompleks Perumdam, Jl. R.A Abusamah, Simpang 5"));
        items.add(new Lokasi(R.drawable.masjid,"Kediaman Ust. Aidil","Jl. Supersemar, samping gedung Graha 66, Angkatan 66"));
        return items;
    }

}

