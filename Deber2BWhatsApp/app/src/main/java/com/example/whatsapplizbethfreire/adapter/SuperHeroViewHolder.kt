package com.example.whatsapplizbethfreire.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapplizbethfreire.Netflix
import com.example.whatsapplizbethfreire.R

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view){

    val seperHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val photo: ImageView = view.findViewById<ImageView>(R.id.ivSuperHero)
    val nombre = view.findViewById<TextView>(R.id.nombreContacto)

    fun render(superHeroModel: Netflix) {
        nombre.text = superHeroModel.grupo
        seperHero.text = superHeroModel.superhero
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
        }
}