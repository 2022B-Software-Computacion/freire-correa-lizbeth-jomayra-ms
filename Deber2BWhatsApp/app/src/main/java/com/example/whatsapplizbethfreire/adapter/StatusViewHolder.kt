package com.example.whatsapplizbethfreire.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapplizbethfreire.EstadosVar
import com.example.whatsapplizbethfreire.R
import com.example.whatsapplizbethfreire.SuperHero

class StatusViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val nombreStatus = view.findViewById<TextView>(R.id.id_nombreEstado)
    val  dateStatus= view.findViewById<TextView>(R.id.id_dateEstado)
    val fotoStatus = view.findViewById<ImageView>(R.id.id_fotoEstados)
    fun renderEstados(estadosModel: EstadosVar){
        nombreStatus.text = estadosModel.nombreEstado
        dateStatus.text = estadosModel.dateEstado
        Glide.with(fotoStatus.context).load(estadosModel.fotoEstado).into(fotoStatus)
    }
}