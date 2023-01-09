package com.example.ljfcapplication

class BBaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()
        init{
            arregloBEntrenador
                .add(
                    BEntrenador("Liz", "l@l.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Jomy", "j@j.com")
                )
            arregloBEntrenador
                .add(
                    BEntrenador("Anto", "a@a.com")
                )
        }
    }
}