package com.kborodin.mapweatherforecast.view.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.kborodin.mapweatherforecast.MyApp
import com.kborodin.mapweatherforecast.R
import kotlinx.android.synthetic.main.activity_main.*
import permissions.dispatcher.NeedsPermission

private const val CURRENT_COORD = "currentCoord"

class MainActivity : AppCompatActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {

    private lateinit var map: GoogleMap
    private lateinit var googleApiClient: GoogleApiClient
    private lateinit var locationRequest: LocationRequest

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fab.hide()
    }

    @SuppressLint("MissingPermission")
    @NeedsPermission(
        FINE_LOCATION,
        COARSE_LOCATION
    )
    override fun onMapReady(googleMap: GoogleMap?) {
        map = googleMap!!
        map.isMyLocationEnabled = true
        buildGoogleApiClient()

        map.setOnMapClickListener {latLng ->
            map.clear()
            map.addMarker(MarkerOptions().position(latLng))
            fab.show()

            fab.setOnClickListener {
                fabClick(latLng)
            }
        }
    }

    private fun fabClick(latLng: LatLng) {
        val intent = Intent(this, WeatherActivity::class.java)
        intent.putExtra(CURRENT_COORD, latLng)
        startActivity(intent)
    }

    private fun buildGoogleApiClient() {
        googleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build()
        googleApiClient.connect()
    }

    @SuppressLint("MissingPermission")
    override fun onConnected(p0: Bundle?) {
        locationRequest = LocationRequest()
        locationRequest.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY
        LocationServices.FusedLocationApi.requestLocationUpdates(googleApiClient, locationRequest, this)
    }

    override fun onConnectionSuspended(p0: Int) {
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
    }

    override fun onLocationChanged(p0: Location?) {
    }
}
