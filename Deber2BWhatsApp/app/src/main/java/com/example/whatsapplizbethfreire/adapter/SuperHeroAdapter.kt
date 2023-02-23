package com.example.whatsapplizbethfreire.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.whatsapplizbethfreire.R
import com.example.whatsapplizbethfreire.SuperHero

class SuperHeroAdapter(val superheroList: List<SuperHero>):  RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return SuperHeroViewHolder(layoutInflater.inflate(R.layout.item_superhero,parent, false))
    }

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        val item = superheroList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
       return superheroList.size
    }

}