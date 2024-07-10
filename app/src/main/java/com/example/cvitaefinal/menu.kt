package com.example.cvitaefinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)


        // Encontrar el botón por su ID
        val btnmenu = findViewById<Button>(R.id.btn_menu)

        // Configurar el click listener del botón
        btnmenu.setOnClickListener {
            // Crear un Intent para abrir RegistroActivity
            val intent = Intent(this, incio::class.java)
            startActivity(intent)
        }
    }
}