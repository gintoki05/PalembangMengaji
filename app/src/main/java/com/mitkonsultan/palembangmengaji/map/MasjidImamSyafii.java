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

public class MasjidImamSyafii extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjid_mias);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapmias);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        // Menambah marker di Masjid Imam Syafii, Indonesia, dan menggerakan kamera.
        LatLng masjidmias = new LatLng(-2.9987158,104.7970837);
        gMap.addMarker(new MarkerOptions().position(masjidmias).title("Masjid Imam Syafi'i"));
        float zoomLevel = 16.0f;
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(masjidmias, zoomLevel));
    }

}
