package Model

class Persona(
    private var nombre: String,
    private var apellidos: String,
    private var dni: String
) : Interface {
    override fun devolverInfo(): String {
        return "Persona(nombre='$nombre', apellidos='$apellidos', dni='$dni')"
    }
}