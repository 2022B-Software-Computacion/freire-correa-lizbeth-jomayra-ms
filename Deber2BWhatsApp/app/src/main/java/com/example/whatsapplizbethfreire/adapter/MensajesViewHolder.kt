package com.example.whatsapplizbethfreire.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.whatsapplizbethfreire.R
import com.example.whatsapplizbethfreire.PantallaPrincipal

class MensajesViewHolder (view: View):RecyclerView.ViewHolder(view){
    val fecha = view.findViewById<TextView>(R.id.horadate)
    val nombre = view.findViewById<TextView>(R.id.idMensajeName)
    val mensaje = view.findViewById<TextView>(R.id.idMensaje)
    val foto = view.findViewById<ImageView>(R.id.idFotoMensajes)
    fun render(mensajeModel: PantallaPrincipal){
        fecha.text = mensajeModel.date
        nombre.text = mensajeModel.mensajeNombre
        mensaje.text = mensajeModel.mensajeText
        Glide.with(foto.context).load(mensajeModel.photo).into(foto)
    }
}