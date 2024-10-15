/** SE PONE CON OPEN PORQUE VOY A DAR LA POSIBILIDAD DE QUE LA CLASE SEA HEREDADA */
open class Persona(var telefono: Long = 983999999) {
    var nombre: String = ""
        get() {
            // NO HACE REFERENCIA AL NOMBRE PORQUE GENERARIA RECURSIVIDAD LO QUE GENERARIA UN BUCLE INFINITO
            // ASIQUE SE ACCEDE AL VALOR CON EL METODO 'field'
            return field.uppercase()
        } // EN EL METODO GET RETORNA EL VALOR DEL CAMPO CON TODOS SUS CARACTERES EN MAYUSCULAS
        set(value) {
            if (value.length > 10) {
                field = "nombre_muylargo"
            } else
                field = value
        }

    lateinit var dni: String  // PROPIEDAD 'dni' QUE SE INICIALIZA MAS TARDE

    constructor(dni: String) : this() { // SE PUEDE REFERENCIAR A UN CONSTRUCTOR VACIO PORQUE EL VALOR POR DEFECTO YA TIENE UN VALOR
        this.dni = dni
    } // CONSTRUCTOR CON EL DNI

    constructor(dni: String, nombre: String, tel: Long) // NO SON PARAMETROS DE LA CLASE
            : this(tel) { // DE FORMA EXPLICITA PASANDO LOS PARAMETROS
        this.dni = dni
        this.nombre = nombre
    } // CONSTRUCTOR SECUNDARIO CON 3 PARAMETROS

    init {
        println("Esto es el bloque init")
    } // CUANDO SE CREA UN OBJETO DE LA CLASE

    open fun devolver_Info(): String {
        return ("Dni: $dni;Nombre: $nombre;Telefono: $telefono") // CONCATENA LOS VALORES
    }
}

// PUEDE PASAR LA CLASE SIN tel
class Trabajador(var sueldo: Double = 0.0 , tel: Long) : Persona(tel) { // tel ES UN PARAMETRO PORQUE NO VA CON VAR (es decir, qeu no es un atributo de la clase)
    constructor(): this(0.0, 0){
    } // CONSTRUCTOR VACIO (t1)

    override fun devolver_Info(): String {
        return super.devolver_Info() + "Sueldo: $sueldo"
    } // RETORNAR LOS VALORES DE PERSONA Y SU ATRIBUTO
}