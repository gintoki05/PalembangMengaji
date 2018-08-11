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

public class MusallaDarussalam extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musalla_darussalam);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapdarussalam);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        // Menambah marker di Musalla Darussalam , Indonesia, dan menggerakan kamera.
        LatLng musalladarussalam = new LatLng(-2.9647158,104.8046075);
        gMap.addMarker(new MarkerOptions().position(musalladarussalam).title("Musalla Darussalam"));
        float zoomLevel = 16.0f;
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(musalladarussalam, zoomLevel));
    }

}
