package com.example.whatsapplizbethfreire

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapplizbethfreire.adapter.SuperHeroAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
    }
    private fun initRecyclerView() {
        // recyclerView RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.whatsAppRecyclerView1)
        recyclerView.layoutManager =
            LinearLayoutManager(this)//this
        recyclerView.adapter = SuperHeroAdapter(NetflixProvider.superheroList)
    }
}