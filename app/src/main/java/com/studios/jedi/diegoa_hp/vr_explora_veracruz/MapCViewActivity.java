package com.studios.jedi.diegoa_hp.vr_explora_veracruz;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapCViewActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private String cityName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapc_view);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getString("cityN2") != null ){
            cityName = bundle.getString("cityN2");
        }
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
        double lat=0;
        double lon=0;
        String city="";
        // Add a marker in ciudad and move the camera
        //Aquí pususte un Switch para las ciudades, solo metiste un switch, no te espantes si no funciona o no recuerdas que moviste Diego
        //en los case, solo moviste Lat y Long, y el nombre del title
        switch (cityName) {
            case "Coatzacoalcos":
                /*LatLng ciudad = new LatLng(18.1342154, -94.4979665);
                mMap.addMarker(new MarkerOptions().position(ciudad).title("Coatzacoalcos, Ver."));

                CameraPosition camera = new CameraPosition.Builder()
                        .target(ciudad)
                        .zoom(12)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
                lat= 18.1342154;
                lon= -94.4979665;
                city="Coatzacoalcos, Ver.";
                break;
            case "Minatitlan":
                /*LatLng ciudad2 = new LatLng(18.0024108, -94.588454);
                mMap.addMarker(new MarkerOptions().position(ciudad2).title("Minatitlan, Ver."));

                CameraPosition camera2= new CameraPosition.Builder()
                        .target(ciudad2)
                        .zoom(12)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera2));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
                lat= 18.0024108;
                lon= -94.588454;
                city="Minatitlan, Ver.";
                break;
            case "Pajapan":
                /*LatLng ciudad3 = new LatLng(18.2636849, -94.7029499);
                mMap.addMarker(new MarkerOptions().position(ciudad3).title("Pajapan, Ver."));

                CameraPosition camera3= new CameraPosition.Builder()
                        .target(ciudad3)
                        .zoom(12)
                        .build();

                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera3));
                //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
                lat= 18.262565;
                lon= -94.7010377;
                city="Pajapan, Ver.";
                break;
            default:
                break;
        }
        LatLng ciudad = new LatLng(lat, lon);
        mMap.addMarker(new MarkerOptions().position(ciudad).title(city));

        CameraPosition camera = new CameraPosition.Builder()
                .target(ciudad)
                .zoom(13)
                .build();

        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
