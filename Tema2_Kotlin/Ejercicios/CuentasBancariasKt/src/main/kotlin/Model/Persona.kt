package Model

class Persona (var nombre:String, var apellidos:String, var dni:String) {
    override fun toString(): String {
        return "Persona(nombre='$nombre', apellidos='$apellidos', dni='$dni')"
    }
}