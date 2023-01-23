import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter
import java.lang.Exception
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
                    actualizarUniversidad()
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

fun agregarUniversidad(){
    var universidad1 = Universidad()
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    // Obtener los datos de universidad
    println("Ingrese el id de la universidad: ")
    universidad1.id = readln().toInt()
    println("Ingrese el nombre de la universidad ")
    universidad1.nombre = readln()
    println("Ingrese la ciudad: ")
    universidad1.ciudad = readln()
    println("Ingrese el número de facultades existentes: ")
    universidad1.numeroDeFacultades = readln().toInt()
    println("Escriba V si es categoría A. Caso contrario, escriba F: ")
    universidad1.esCategoriaA = readln() == "V"
    universidad1.listaFacultades = agregarListaFacultades()
    try {
        archivo = File("universidades.txt")
        fw = FileWriter(archivo, true)
        pw = PrintWriter(fw)
        //
        pw.println(universidad1.obtenerAtributos())

    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
fun listarUniversidades(){
    val listaUniversidades = mutableListOf<Universidad>()
    try {
        val file = File("universidades.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach {
            var miListaFacultades = mutableListOf<Facultad>()
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevaUniversidad = Universidad()
            nuevaUniversidad.id = dato.toInt()
            dato = tokens.nextToken()
            nuevaUniversidad.nombre = dato
            dato = tokens.nextToken()
            nuevaUniversidad.ciudad = dato
            dato = tokens.nextToken()
            nuevaUniversidad.fechaFundacion = LocalDate.parse(dato)
            dato = tokens.nextToken()
            nuevaUniversidad.numeroDeFacultades = dato.toInt()
            dato = tokens.nextToken()
            nuevaUniversidad.esCategoriaA = dato.toBoolean()

            while (tokens.hasMoreTokens()) {
                dato = tokens.nextToken()
                miListaFacultades.add(obtenerFacultadPorId(dato.toInt()))
            }
            nuevaUniversidad.listaFacultades = miListaFacultades
            listaUniversidades.add(nuevaUniversidad)
        }

    } catch (e: IOException) {
        e.printStackTrace()
    }
    listaUniversidades.forEach{
        println(it.toString())
    }
}
fun actualizarUniversidad(){
    val listaUniversidad = mutableListOf<Universidad>()
    println("Introduzca el ID de la Universidad")
    val id = readln().toInt()
    // Lee el archivo y genera una lista de universidades actuales
    val file = File("universidades.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        var miListaFacultad = mutableListOf<Facultad>()
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaUniversidad = Universidad()
        dato = tokens.nextToken()
        nuevaUniversidad.nombre = dato
        dato = tokens.nextToken()
        nuevaUniversidad.ciudad = dato
        dato = tokens.nextToken()
        nuevaUniversidad.fechaFundacion = LocalDate.parse(dato)
        dato = tokens.nextToken()
        nuevaUniversidad.numeroDeFacultades = dato.toInt()
        dato = tokens.nextToken()
        nuevaUniversidad.esCategoriaA = dato.toBoolean()
        // aquí se vuelve a realizar una búsqueda por tokens
        while(tokens.hasMoreTokens()){
            dato = tokens.nextToken()
            miListaFacultad.add(obtenerFacultadPorId(dato.toInt()))
        }
        nuevaUniversidad.listaFacultades = miListaFacultad
        listaUniversidad.add(nuevaUniversidad)
    }
    var univerdidadAux = Universidad()
    listaUniversidad.forEach {
        if (it.id == id){
            univerdidadAux = it
        }
    }
    val indiceUniversidad = listaUniversidad.indexOf(univerdidadAux)
    // Eliminamos el album anterior
    listaUniversidad.remove(univerdidadAux)
    // Actualizamos los datos
    println("Ingrese el nombre: ")
    univerdidadAux.nombre = readln()
    println("Ingrese la ciudad: ")
    univerdidadAux.ciudad = readln()
    println("Ingrese la fecha de fundación : ")
    univerdidadAux.fechaFundacion = LocalDate.parse(readln())
    println("Ingrese el numero de facultades : ")
    univerdidadAux.numeroDeFacultades = readln().toInt()
    println("Escriba V si la universidad es categoria A. Caso contrario, escriba F: ")
    univerdidadAux.esCategoriaA = readln() == "V"
    // Añadimos el album actualizado
    listaUniversidad.add(indiceUniversidad, univerdidadAux)

    // Reescribir el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("universidades.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaUniversidad.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
fun eliminarUniversidad(){
    val listaUniversidad = mutableListOf<Universidad>()
    println("Introduzca el ID de la universidad")
    val id = readln().toInt()
    // Lee el archivo y genera una lista
    val file = File("universidades.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        var miListaFacultad = mutableListOf<Facultad>()
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaUniversidad = Universidad()
        nuevaUniversidad.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaUniversidad.nombre = dato
        dato = tokens.nextToken()
        nuevaUniversidad.ciudad = dato
        dato = tokens.nextToken()
        nuevaUniversidad.fechaFundacion = LocalDate.parse(dato)
        dato = tokens.nextToken()
        nuevaUniversidad.numeroDeFacultades = dato.toInt()
        dato = tokens.nextToken()
        nuevaUniversidad.esCategoriaA = dato.toBoolean()
        // aquí se vuelve a realizar una búsqueda por tokens
        while(tokens.hasMoreTokens()){
            dato = tokens.nextToken()
            miListaFacultad.add(obtenerFacultadPorId(dato.toInt()))
        }
        nuevaUniversidad.listaFacultades = miListaFacultad
        listaUniversidad.add(nuevaUniversidad)
    }
    var universidadAux = Universidad()
    listaUniversidad.forEach {
        if (it.id == id){
            universidadAux = it
        }
    }
    listaUniversidad.remove(universidadAux)
    // Ya se tiene una lista sin el elemento
    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("universidades.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaUniversidad.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
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
fun obtenerFacultadPorId(id: Int): Facultad{
    val listaFacultades = mutableListOf<Facultad>()
    var facultad = Facultad()
    try {
        val file = File("Facultades.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach {
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevaFacultad = Facultad()
            nuevaFacultad.id = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.nombre = dato
            dato = tokens.nextToken()
            nuevaFacultad.numeroCarreras = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.numeroProfesores = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.numeroEstudiantes = dato.toInt()
            dato = tokens.nextToken()
            listaFacultades.add(nuevaFacultad)

        }
    } catch (e: IOException){
        e.printStackTrace()
    }
    listaFacultades.forEach(){
        if (it.id == id){
            facultad = it
        }
    }
    return facultad
}
fun agregarFacultad(){
    var facultad1 = Facultad()
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?

    //Obtiene los datos
    println("Ingrese le id de la Facultad: ")
    facultad1.id = readln().toInt()
    println("Ingrese el nombre de la Facultad: ")
    facultad1.nombre = readln()
    println("Ingrese el número de carreras que oferta: ")
    facultad1.numeroCarreras = readln().toInt()
    println("Ingrese el número de Profesores: ")
    facultad1.numeroProfesores = readln().toInt()
    println("Ingrese el número de estudiantes: ")
    facultad1.numeroEstudiantes = readln().toInt()
    try{
        archivo = File("Facultades.txt")
        fw = FileWriter(archivo, true)
        pw = PrintWriter(fw)
        //
        pw.println(facultad1.obtenerAtributos())
    }catch (e: Exception){
        e.printStackTrace()
    }finally {
        try {
            fw?.close()
        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}
fun listarFacultades(){
    val listaFacultades = mutableListOf<Facultad>()
    try{
        val file = File("Facultades.txt")
        val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
        reader.lines().forEach {
            val tokens = StringTokenizer(it, ",")
            var dato: String = tokens.nextToken()
            val nuevaFacultad = Facultad()
            nuevaFacultad.id = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.nombre = dato
            dato = tokens.nextToken()
            nuevaFacultad.numeroCarreras = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.numeroProfesores = dato.toInt()
            dato = tokens.nextToken()
            nuevaFacultad.numeroEstudiantes = dato.toInt()
            dato = tokens.nextToken()

        }
    }catch (e: IOException){
        e.printStackTrace()
    }
    println(listaFacultades)
}
fun actualizarFacultad(){
    val listaFacultad = mutableListOf<Facultad>()
    println("Introduzca el ID de la facultad ")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las facultades actuales
    val file = File("Facultades.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaFacultad = Facultad()
        nuevaFacultad.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.nombre = dato
        dato = tokens.nextToken()
        nuevaFacultad.numeroCarreras = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.numeroProfesores = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.numeroEstudiantes = dato.toInt()
        dato = tokens.nextToken()
    }
    var facultadAux = Facultad()
    listaFacultad.forEach {
        if (it.id == id){
            facultadAux = it
        }
    }
    val indiceFacultad = listaFacultad.indexOf(facultadAux)
    // Eliminamos la cancion anterior
    listaFacultad.remove(facultadAux)
    // Actualizamos la información
    print("Ingrese el nombre: ")
    facultadAux.nombre = readln()
    print("Ingrese el número de carreras: ")
    facultadAux.numeroCarreras = readln().toInt()
    print("Ingrese el número de profesores: ")
    facultadAux.numeroProfesores = readln().toInt()
    print("Ingrese el número de estudiantes: ")
    facultadAux.numeroEstudiantes = readln().toInt()
    // Añadimos la informacion actualizada
    listaFacultad.add(indiceFacultad, facultadAux)

    println(listaFacultad)

    // Reescribir todoo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Facultades.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaFacultad.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
fun eliminarFacultad(){
    val listaFacultad = mutableListOf<Facultad>()
    println("Introduzca el ID de la Facultad")
    val id = readln().toInt()
    // Lee el archivo y genera una lista con las facultades
    val file = File("Facultades.txt")
    val reader = BufferedReader(FileReader(file, Charsets.UTF_8))
    reader.lines().forEach {
        val tokens = StringTokenizer(it, ",")
        var dato: String = tokens.nextToken()
        val nuevaFacultad = Facultad()
        nuevaFacultad.id = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.nombre = dato
        dato = tokens.nextToken()
        nuevaFacultad.numeroCarreras = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.numeroProfesores = dato.toInt()
        dato = tokens.nextToken()
        nuevaFacultad.numeroEstudiantes = dato.toInt()
        dato = tokens.nextToken()
    }
    var facultadAux = Facultad()
    listaFacultad.forEach {
        if (it.id == id){
            facultadAux = it
        }
    }
    listaFacultad.remove(facultadAux)
    // Vamos a reescribir toodo el archivo
    var archivo: File?
    var fw: FileWriter? = null
    var pw: PrintWriter?
    try {
        archivo = File("Facultades.txt")
        fw = FileWriter(archivo)
        pw = PrintWriter(fw)
        listaFacultad.forEach {
            pw.println(it.obtenerAtributos())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            fw?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}

