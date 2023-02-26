package com.example.whatsapplizbethfreire

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapplizbethfreire.adapter.MensajesAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val btnIrEstados = findViewById<Button>(R.id.id_irEstados)
        btnIrEstados.setOnClickListener{
            val lanzar = Intent(this, Estados::class.java)
            startActivity(lanzar
            )
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menumain,menu)
        return true
    }
    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerSuperHero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MensajesAdapter(PantallaPrincipalProvider.mensajesList)
    }

}
