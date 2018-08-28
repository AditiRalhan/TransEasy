package com.example.aditi.transeasy;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class Private_Trucks_MapsActivity extends FragmentActivity implements OnMapReadyCallback {

   GoogleMap mMap;
   int i=1;
    double latitude1,latitude2,latitude3,latitude4,latitude5 ;
    double longitude1,longitude2,longitude3,longitude4,longitude5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private__trucks__maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        latitude1=18.9679;
        longitude1=73.1308;

        latitude5=12.58;
        longitude5=77.35;

        latitude3=28.40;
        longitude3=77.14;

        latitude4=22.30;
        longitude4=88.20;

        latitude2=23.03;
        longitude2=70.11;

        Geocoder geocoder = new Geocoder(getApplicationContext());
        try {
            List<Address> addresses =
                    geocoder.getFromLocation(latitude1, longitude1, 1);
            String result = addresses.get(0).getLocality() + ":";
            List<Address> addresses2 =
                    geocoder.getFromLocation(latitude2, longitude2, 1);
            String result2 = addresses2.get(0).getLocality() + ":";
            List<Address> addresses3 =
                    geocoder.getFromLocation(latitude3, longitude3, 1);
            String result3 = addresses3.get(0).getLocality() + ":";
            List<Address> addresses4 =
                    geocoder.getFromLocation(latitude4, longitude4, 1);
            String result4 = addresses4.get(0).getLocality() + ":";
            List<Address> addresses5=
                    geocoder.getFromLocation(latitude5, longitude5, 1);
            String result5 = addresses5.get(0).getLocality() + ":";

            result += "Truck1";
            result2 += "ship1";
            result3 += "Truck3";
            result4 += "ship2";
            result5 += "Truck5";


            LatLng latLng1 = new LatLng(latitude1, longitude1);
            LatLng latLng2 = new LatLng(latitude1, longitude2);
            LatLng latLng3 = new LatLng(latitude1, longitude3);
            LatLng latLng4 = new LatLng(latitude1, longitude4);
            LatLng latLng5 = new LatLng(latitude1, longitude5);


            mMap.addMarker(new MarkerOptions().position(latLng1).title(result));
            mMap.addMarker(new MarkerOptions().position(latLng2).title(result2));
            mMap.addMarker(new MarkerOptions().position(latLng3).title(result3));
            mMap.addMarker(new MarkerOptions().position(latLng4).title(result4));
            mMap.addMarker(new MarkerOptions().position(latLng5).title(result5));
            mMap.setMaxZoomPreference(20);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng1, 12.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 12.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng3, 12.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng4, 12.0f));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng5, 12.0f));

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        // Add a marker in Sydney and move the camera
       // LatLng sydney = new LatLng(-34, 151);
       // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
      //  mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
