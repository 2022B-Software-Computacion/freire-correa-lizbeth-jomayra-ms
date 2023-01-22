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
    fun leerAlbum(){
        var archivo: File? = null
        var fr: FileReader? = null
        var br: BufferedReader? = null
        try {
            archivo = File("Albumes.txt")
            fr = FileReader(archivo)
            br = BufferedReader(fr)
            var linea: String
            while (br.readLine().also { linea = it } != null) {
                val tokens = StringTokenizer(linea, ",")
                var dato: String = tokens.nextToken()
                val nuevoAlbum = Album()
                nuevoAlbum.numCanciones = dato.toInt()
                dato = tokens.nextToken()
                nuevoAlbum.fechaLanzamiento = LocalDate.parse(dato)
                dato = tokens.nextToken()
                nuevoAlbum.nombre = dato
                dato = tokens.nextToken()
                nuevoAlbum.duracionTotal = dato.toFloat()
                dato = tokens.nextToken()
                nuevoAlbum.esDebut = dato.toBoolean()
                dato = tokens.nextToken()
                // aquí se debe añadir una lista de canciones
                agregarListaCanciones()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
