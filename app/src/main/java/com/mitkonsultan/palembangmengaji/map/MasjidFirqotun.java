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

public class MasjidFirqotun extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap gMap;
    MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masjid_firqotun);

        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.mapfirqotun);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;

        // Menambah marker di Masjid Firqotun , Indonesia, dan menggerakan kamera.
        LatLng masjidfirqotun = new LatLng(-2.9445721,104.6829321);
        gMap.addMarker(new MarkerOptions().position(masjidfirqotun).title("Masjid Firqotun Najiyah"));
        float zoomLevel = 16.0f;
        gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(masjidfirqotun, zoomLevel));
    }

}
