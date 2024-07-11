package com.example.cvitaefinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.inject.Provider
import kotlin.math.sign

class registro : AppCompatActivity() {
    private lateinit var regis: Button
    private lateinit var email: EditText
    private lateinit var contra: EditText
    private lateinit var inicio : Button
    private val analytics by lazy {
        FirebaseAnalytics.getInstance(this)
    }
    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro)

        //Analytic Event
        val bundle = Bundle()
        bundle.putString("message", "Integracion de Firebase completa")
        analytics.logEvent("InitScreen", bundle)

        setup()
    }
    private fun setup(){
        title = "Autenticacion"
        inicio = findViewById(R.id.btnInicio)
        inicio.setOnClickListener{
            val intent = Intent(this, inicio::class.java)
            startActivity(intent)
        }
        regis = findViewById(R.id.btn_registro)
        email = findViewById(R.id.txt_email)
        contra = findViewById(R.id.txt_contraseña)
        regis.setOnClickListener {
            if (findViewById<EditText>(R.id.txt_email).text.toString() != "" && findViewById<EditText>(R.id.txt_contraseña).text.toString()!=""){

               auth.createUserWithEmailAndPassword(email.text.toString(), contra.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        showHome(it.result?.user?.email ?: "", ProviderType.BASIC)
                    }else{
                        showAlert()
                    }
                }

            }

        }

    }
    private fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("No se pudo autenticar el usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun showHome(email: String, provider: ProviderType){
        val homeIntent = Intent(this, pagina_principal::class.java).apply {
                putExtra("email", email)
                putExtra("provider", provider.name)
        }
        startActivity(homeIntent)
    }
}

