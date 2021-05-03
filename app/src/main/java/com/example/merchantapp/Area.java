package com.example.merchantapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Area extends AppCompatActivity implements OnMapReadyCallback {
    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;
    public LatLng latLng;
    EditText editText1;
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchPreviousLocation();
        initwidget();
    }

    private void initwidget() {
        editText1 =findViewById(R.id.areaa);

    }

    private void fetchPreviousLocation() {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }

        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    currentLocation = location;
                    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
                    mapFragment.getMapAsync(Area.this);

                }
            }        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
            this.googleMap = googleMap;
            latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(Area.this, Locale.getDefault());

            try {
                addresses = geocoder.getFromLocation(currentLocation.getLatitude(), currentLocation.getLongitude(), 1);
                String city = addresses.get(0).getLocality();
                String address = addresses.get(0).getAddressLine(0);

                googleMap.addMarker(new MarkerOptions().position(latLng).title(address + ", " + city));
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5));
                editText1.setText(address);
                // editText3.setText(city);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
