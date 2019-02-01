package com.kborodin.mapweatherforecast.view

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import permissions.dispatcher.*

const val FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION
const val COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION

@RuntimePermissions
class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openMapClickWithPermissionCheck()
    }
    @NeedsPermission(FINE_LOCATION, COARSE_LOCATION)
    fun openMapClick() {
        val isFineLocationGranted =
            ContextCompat.checkSelfPermission(this, FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
        val isCoarseLocationGranted =
            ContextCompat.checkSelfPermission(this, COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (isFineLocationGranted && isCoarseLocationGranted) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            toast(getString(com.kborodin.mapweatherforecast.R.string.locationDenied))
        }
    }

    @OnShowRationale(FINE_LOCATION, COARSE_LOCATION)
    fun showRationaleForMap(request: PermissionRequest) {
        AlertDialog.Builder(this)
            .setPositiveButton(com.kborodin.mapweatherforecast.R.string.ok) { _, _ -> request.proceed() }
            .setNegativeButton(com.kborodin.mapweatherforecast.R.string.cancel) { _, _ -> request.cancel() }
            .setCancelable(false)
            .setMessage(getString(com.kborodin.mapweatherforecast.R.string.permissionLocationRationale))
            .show()
    }

    @OnPermissionDenied(FINE_LOCATION, COARSE_LOCATION)
    fun onLocationDenied() {
        toast(getString(com.kborodin.mapweatherforecast.R.string.locationDenied))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        onRequestPermissionsResult(requestCode, grantResults)
    }
}
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}