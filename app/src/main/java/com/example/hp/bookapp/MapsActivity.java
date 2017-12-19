package com.example.hp.bookapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ZoomControls;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(14.0f);
    }

    public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;



        
        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList =geocoder.getFromLocationName(location,1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

        }
    }

    private void addItems() {

        // Set some lat/lng coordinates to start with.
        double lat = -1.2618 ;
        double lng = 36.8035;

        // Add ten cluster items in close proximity, for purposes of this example.
        //
        //for (int i = 0; i < 10; i++) {
            // double offset = i / 60d;
            //lat = lat + offset;
            //lng = lng + offset;

            LatLng latLng = new LatLng(lat, lng);

            mMap.addMarker(new MarkerOptions()
                    .title(getString(R.string.default_info_title))
                    .position(latLng)
                    .snippet(getString(R.string.default_info_snippet)));

//            MyItem offsetItem = new MyItem(lat, lng);
//            mClusterManager.addItem(offsetItem);
//            MyItem infoWindowItem = new MyItem(lat, lng);
//            mClusterManager.addItem(infoWindowItem);


        }

   // }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        LatLng nairobi = new LatLng(-1.2920659,36.82194619999996 );
        mMap.addMarker(new MarkerOptions().position(nairobi).title("Nairobi, Kenya"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nairobi));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mMap.setMyLocationEnabled(true);




//           MyItem offsetItem = new MyItem(lat, lng);
//            mClusterManager.addItem(offsetItem);
//            MyItem infoWindowItem = new MyItem(lat, lng);
//            mClusterManager.addItem(infoWindowItem);
            }

        }






