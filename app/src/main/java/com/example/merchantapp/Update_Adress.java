package com.example.merchantapp;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Update_Adress extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    public LatLng latLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__adress);
        SupportMapFragment mapFragment=(SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap=googleMap;
        LatLng latLng=new LatLng(29.539611,68.744861);
        googleMap.addMarker(new MarkerOptions().position(latLng).title("kohlu,pakistan"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));
        Geocoder geocoder;
        List<Address> addresses;

        geocoder = new Geocoder(Update_Adress.this, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);
            String city = addresses.get(0).getLocality();
            String address = addresses.get(0).getAddressLine(0);

            googleMap.addMarker(new MarkerOptions().position(latLng).title(address+", "+city));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,5));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}