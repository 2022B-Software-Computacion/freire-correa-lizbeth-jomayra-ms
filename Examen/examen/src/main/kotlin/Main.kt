import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException
import java.time.LocalDate
import java.util.*

fun main(){
        var flagMenu = true
        //Menu
        while (flagMenu) {
            println("Bienvenidos, seleccione una opción")
            println("1. Universidades")
            println("2. Facultades")
            println("3. Salir")

            var opcion = readln().toInt()
            //No existe el Switch
            when(opcion){
                (1) -> {
                    flagMenu = true
                    abrirMenuUniversidades()
                }
                (2) -> {
                    flagMenu = true
                    abrirMenuFacultades()
                }
                (3) -> {
                    flagMenu = false
                }
                else -> println("Ingrese una opción válida")
            }

        }

    }

    fun abrirMenuUniversidades() {
        var flagUniversidad = true
        while (flagUniversidad){
            println("1. Agregar una universidad")
            println("2. Listar universidades")
            println("3. Actualizar")
            println("4. Eliminar")
            println("5. Salir")

            var opcion = readln().toInt()
            when(opcion){
                (1) -> {
                    agregarUniversidad()
                }
                (2) -> {
                    listarUniversidades()
                }
                (3) -> {
                    actualizarUniversidades()
                }
                (4) -> {
                    eliminarUniversidad()
                }
                (5) -> {
                    flagUniversidad = false
                }
                else -> println("Por favor,  ingrese una opción válida")
            }
        }
    }
    fun abrirMenuFacultades() {
        var flagFacultad = true
        while(flagFacultad){
            println("1. Agregar facultad")
            println("2. Listar facultades")
            println("3. Actualizar una cancion")
            println("4. Eliminar una cancion")
            var opcion = readln().toInt()
            when (opcion){
                (1) -> {
                    agregarFacultad()
                }
                (2) -> {
                    listarFacultades()
                    println("\n")
                }
                (3) -> {
                    actualizarFacultad()
                }
                (4) -> {
                    eliminarFacultad()
                }
                (5) -> {
                    flagFacultad = false
                }
                else -> println("Por favor,  ingrese una opción válida")
            }
        }
    }
    fun leerUniversidad(){
        var archivo: File? = null
        var fr: FileReader? = null
        var br: BufferedReader? = null
        try {
            archivo = File("Universidades.txt")
            fr = FileReader(archivo)
            br = BufferedReader(fr)
            var linea: String
            while (br.readLine().also { linea = it } != null) {
                val tokens = StringTokenizer(linea, ",")
                var dato: String = tokens.nextToken()
                val nuevaUniversidad = Universidad()
                nuevaUniversidad.nombre = dato
                dato = tokens.nextToken()
                nuevaUniversidad.ciudad = dato
                dato = tokens.nextToken()
                nuevaUniversidad.fechaFundacion = LocalDate.parse(dato)
                dato = tokens.nextToken()
                nuevaUniversidad.numeroDeFacultades = dato.toInt()
                dato = tokens.nextToken()
                nuevaUniversidad.esCategoriaA = dato.toBoolean()
                dato = tokens.nextToken()
                // aquí se debe añadir una lista de facultades
                agregarListaFacultades()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

fun agregarListaFacultades() : MutableList<Facultad> {
    var listaFacultadesNuevas = mutableListOf<Facultad>()
    var aux = Facultad()
    var flag1 = true
    while (flag1) {
        println("¿Desea agregar una Facultad a alguna Universidad?")
        println("Y / N")
        if (readln().equals("N")){
            return listaFacultadesNuevas
        }else{
            println("Ingrese el ID de una Facultad")
            aux = obtenerFacultadPorId(readln().toInt())
            listaFacultadesNuevas.add(aux)
        }
    }
    return listaFacultadesNuevas
}
