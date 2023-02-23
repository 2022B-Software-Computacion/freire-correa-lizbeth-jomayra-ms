package com.example.whatsapplizbethfreire.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapplizbethfreire.R
import com.example.whatsapplizbethfreire.SuperHero

class SuperHeroViewHolder (view: View):RecyclerView.ViewHolder(view){
    val fecha = view.findViewById<TextView>(R.id.horadate)
    val nombre = view.findViewById<TextView>(R.id.idSuperHeroName)
    val mensaje = view.findViewById<TextView>(R.id.idSuperHeroMensaje)
    val foto = view.findViewById<ImageView>(R.id.idSuperHero)
    fun render(superHeroModel: SuperHero){
        fecha.text = superHeroModel.date
        nombre.text = superHeroModel.superhero
        mensaje.text = superHeroModel.publisher
        Glide.with(foto.context).load(superHeroModel.photo).into(foto)
    }
}