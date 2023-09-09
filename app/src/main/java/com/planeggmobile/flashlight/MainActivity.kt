package com.planeggmobile.flashlight

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.planeggmobile.flashlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Muutujate deklareerimine
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Määrab, et akna dekoratsioonid ei kata süsteemiaknaid
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        // Seob vaate XML-ga
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Seadistab tööriistariba
        setSupportActionBar(binding.toolbar)

        // Navigatsioonikontrolleri loomine
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Seadistab nupu klõpsamise sündmuse
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.fab)
                .setAction("tegevus", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Paisutab menüü; see lisab elemendid tööriistaribale, kui see on olemas.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Käsitseb tööriistariba üksuste klõpsamisi siin. Tööriistariba käsitseb automaatselt
        // klõpsamisi Kodu/Üles nupul, nii kaua kui määrate vanemtegevuse AndroidManifest.xml-is.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> {
                Log.d("MK001","logisse")
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        // Käsitseb navigeerimise üles sündmust
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
