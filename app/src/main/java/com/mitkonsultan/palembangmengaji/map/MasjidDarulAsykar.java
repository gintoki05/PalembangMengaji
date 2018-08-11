package com.mitkonsultan.palembangmengaji.map;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.mitkonsultan.palembangmengaji.R;

public class MasjidDarulAsykar extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjid_darul_asykar);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapds);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        // Menambah marker di Masjid Darul S, Indonesia, dan menggerakan kamera.
        LatLng masjidds = new LatLng(-2.9357906,104.7435818);
        gMap.addMarker(new MarkerOptions().position(masjidds).title("Masjid Darul Asykar"));
        float zoomLevel = 16.0f;
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(masjidds, zoomLevel));
    }

}
