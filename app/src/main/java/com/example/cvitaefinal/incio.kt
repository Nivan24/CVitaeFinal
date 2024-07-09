package com.example.cvitaefinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_incio)

        // Encontrar el botón por su ID
        val btnCrear = findViewById<Button>(R.id.btn_crear)

        // Configurar el click listener del botón
        btnCrear.setOnClickListener {
            // Crear un Intent para abrir RegistroActivity
            val intent = Intent(this, registro::class.java)
            startActivity(intent)
        }
    }
}

