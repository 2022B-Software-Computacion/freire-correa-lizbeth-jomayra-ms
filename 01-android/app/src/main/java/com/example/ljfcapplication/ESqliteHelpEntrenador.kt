package com.example.ljfcapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelpEntrenador (
    contexto: Context?, //this
): SQLiteOpenHelper(
    contexto, "moviles", //nombre BDD
    null,
    1
){
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaEntrenador =
            """
            CREATE TABLE ENTRENADOR(
            id INTEGER PRIMARY KEY AUTOINCREMENT, 
            nombre VARCHAR(50),
            descripcion VARCHAR(50)
        )
        """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaEntrenador)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun crearEntrenador(
        nombre: String,
        descripcion: String
    ): Boolean {
        val baseDatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("descripcion", descripcion)
        val resultadoGuardar = baseDatosEscritura
            .insert(
                "ENTRENADOR", // Nombre tabla
                null,
                valoresAGuardar // valores
            )
        baseDatosEscritura.close()
        return if(resultadoGuardar.toInt() == -1) false else true
    }
    fun eliminarEntrenadorFormulario(id: Int): Boolean{
        //
        val conexionEscritura = writableDatabase
        //
        //
        //
        //
        val resultadoEliminacion = conexionEscritura
            .delete(
                "ENTRENADOR", // Nombre tabla
                "id=?",      // Consulta Where
                arrayOf(
                    id.toString()
                ) // Parametros
            )
        conexionEscritura.close()
        return if (resultadoEliminacion.toInt() == -1) false else true
    }
    fun actualizarEntrenadorFormulario(
        nombre: String,
        descripcion: String,
        idActualizar: Int
    ): Boolean {
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", nombre)
        valoresAActualizar.put("descripcion", descripcion)
        val resultadoActualizacion = conexionEscritura
            .update(
                "ENTRENADOR", // Nombre tabla
                valoresAActualizar, // Valores a Actualizar
                "id=?", //Clausula Where
                arrayOf(
                    idActualizar.toString()
                ) // Parametros clausula Where
            )
        conexionEscritura.close()
        return if(resultadoActualizacion == -1) false else true
    }
    fun consultarEntrenadorPorId(id: Int): BEntrenador {
        val baseDatosLectura = readableDatabase
        val scriptConsultaUsuario = "SELECT * FROM ENTRENADOR WHERE ID = ?"
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaUsuario,
            arrayOf(
                id.toString()
            )
        )
        //Lógica busqueda
        val existeUsuario = resultadoConsultaLectura.moveToFirst()
        val usuarioEncontrado = BEntrenador(0, "", "")
        val arreglo = arrayListOf<BEntrenador>()
        if (existeUsuario){
            do{
                val id = resultadoConsultaLectura.getInt(0) // columna índice 0 -> id
                val nombre = resultadoConsultaLectura.getString(1) // columna índice 1 -> NOMBRE
                val descripcion =
                    resultadoConsultaLectura.getString(2) // columna índice 2 -> DESCRIPCION
                if (id != null){
                    usuarioEncontrado.id = id
                    usuarioEncontrado.nombre = nombre
                    usuarioEncontrado.descripcion = descripcion
                    arreglo.add(usuarioEncontrado)
                }
            }while (resultadoConsultaLectura.moveToNext())
        }

        //val existeUsuario = resultadoConsultaLectura.moveToFirst()

        resultadoConsultaLectura.close()
        return usuarioEncontrado
    }
}