import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate

class Universidad {
        var nombre: String = ""
        var id: Int = 0
        var ciudad: String = ""
        var fechaFundacion: LocalDate? = null
        var numeroDeFacultades: Int = 0
        var esCategoriaA: Boolean = true
        var listaFacultades = mutableListOf<Facultad>()

        constructor(){}

        constructor(
                id: Int,
                nombre: String,
                ciudad: String,
                fechaFundacion: LocalDate?,
                numeroDeFacultades: Int,
                esCategoriaA: Boolean,
                listaFacultades: MutableList<Facultad>
        ) {
                this.id = id
                this.nombre = nombre
                this.ciudad = ciudad
                this.fechaFundacion = fechaFundacion
                this.numeroDeFacultades = numeroDeFacultades
                this.esCategoriaA = esCategoriaA
                this.listaFacultades = listaFacultades
        }
        fun crearUniversidad(){
                val nombreArchivo = "universidades.txt"
                val data = "..text to add.."

                try {
                    FileWriter(nombreArchivo, true).use{
                            it.write(data)
                            println("Text appended to the file")
                    }
                }catch (e: IOException){
                        e.printStackTrace()
                }
        }
        fun obtenerAtributos(): String {
                var idsFacultades: String = ""
                listaFacultades.forEach{
                        idsFacultades += ","+it.id.toString()
                }
                return "$id,$nombre,$ciudad,$fechaFundacion,$numeroDeFacultades, $esCategoriaA"
        }

        override fun toString(): String {
                var facultades: String = ""
                listaFacultades.forEach {
                        facultades += it.nombre + "\n"
                }
                return "\nUniversidad:$id, $nombre, Ciudad: $ciudad, Fundada: $fechaFundacion, Número facultades: $numeroDeFacultades, Categoría: $esCategoriaA\n " +  "Facultades: \n $facultades"
        }


}