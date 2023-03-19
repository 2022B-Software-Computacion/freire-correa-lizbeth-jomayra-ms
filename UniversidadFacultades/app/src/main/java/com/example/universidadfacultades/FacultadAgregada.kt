package com.example.universidadfacultades

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FacultadAgregada : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_facultad_agregada)
    }

    private fun initEventAgregarFacultad(){
        val db = Firebase.firestore
        val btnFirestore = findViewById<Button>(R.id.btn_agregarNuevaFacultad)
        btnFirestore.setOnClickListener {
            val idNuevaFacultad = findViewById<EditText>(R.id.tvIDnuevaFacultad)
            val nombreNuevaFacultad = findViewById<EditText>(R.id.tvNombreFacultad)
            val nombreUniversidad1 = findViewById<EditText>(R.id.tvNombreUniversidad)
            val numeroCarreras = findViewById<EditText>(R.id.tvNumeroCarreras)
            val numeroEstudiantes = findViewById<EditText>(R.id.tvNumeroEstudiantes)
            val numeroDocentes = findViewById<EditText>(R.id.tvNumeroDocentes)

            //db.collection(nombreUniversidad.text.toString()).document()
        }
    }
}