package com.example.ljfcapplication

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador
                .add(
                    BEntrenador(1,"Liz", "l@l.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(2,"Jomy", "j@j.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador(3,"Anto", "a@a.com")
                )
        }
    }
}