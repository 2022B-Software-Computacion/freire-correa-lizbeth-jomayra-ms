import java.time.LocalDate

class Universidad {
            var nombre: String = ""
            var ciudad: String = ""
            var fechaFundacion: LocalDate? = null
            var numeroDeFacultades: Int = 0
            var esCategoriaA: Boolean = true
            var listaFacultades = mutableListOf<Facultad>()
    }