class Facultad {
    var id: Int = 0
    var nombre: String = " "
    var numeroCarreras: Int = 0
    var numeroProfesores: Int = 0
    var numeroEstudiantes: Int = 0

    constructor(){

    }
    constructor(id: Int, nombre: String, numeroCarreras: Int, numeroProfesores: Int, numeroEstudiantes: Int){
        this.id = id
        this.nombre = nombre
        this.numeroCarreras = numeroCarreras
        this.numeroProfesores = numeroProfesores
        this.numeroEstudiantes = numeroEstudiantes
    }

    override fun toString(): String {
        return "Facultad(id=$id, nombre='$nombre', numeroCarreras=$numeroCarreras, numeroProfesores=$numeroProfesores, numeroEstudiantes=$numeroEstudiantes)"
    }
    fun obtenerAtributos(): String{
        return "$id,$nombre,$numeroCarreras,$numeroProfesores,$numeroEstudiantes"
    }


}