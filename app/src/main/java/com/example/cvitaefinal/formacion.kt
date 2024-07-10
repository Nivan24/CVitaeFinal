package com.example.cvitaefinal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.widget.Toolbar
import android.view.View
import androidx.core.view.GravityCompat
import androidx.activity.enableEdgeToEdge

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class Formacion : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private var isMenuOpen = false

    val toolbar: Toolbar = findViewById(R.id.toolbar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formacion)


        setSupportActionBar(toolbar)
        drawerLayout = findViewById(R.id.toolbar)
    }

    fun toggleMenu(view: View) {
        if (isMenuOpen) {
            // Ocultar el menú con animación
            drawerLayout.closeDrawer(GravityCompat.START)
            isMenuOpen = false
        } else {
            // Mostrar el menú con animación
            drawerLayout.openDrawer(GravityCompat.START)
            isMenuOpen = true
        }
    }
}
