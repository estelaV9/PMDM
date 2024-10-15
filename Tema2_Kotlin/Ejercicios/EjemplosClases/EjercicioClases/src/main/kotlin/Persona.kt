open class Persona(var telefono:Long=983999999){
    var nombre:String=""
        get(){
            // NO HACE REFERENCIA AL NOMBRE PORQUE GENERARIA RECURSIVIDAD LO QUE GENERARIA UN BUCLE INFINITO
            // ASIQUE SE ACCEDE AL VALOR CON EL METODO 'field'
            return field.uppercase()
        } // EN EL METODO GET RETORNA EL VALOR DEL CAMPO CON TODOS SUS CARACTERES EN MAYUSCULAS

        set(value)
        {
            if(value.length>10)
            {
                field="nombre_muylargo"
            }
            else
                field=value
        }
    var dni:String=""

    constructor(dni:String):this(){
        this.dni=dni

    }
    constructor(dni:String,nombre:String,tel:Long):this(tel){
        this.dni=dni
        this.nombre=nombre
    }
    init{
       println("Esto es el bloque init")


    }
    protected  open fun devolver_Info():String
    {
     return ("Dni: $dni;Nombre: $nombre;Telefono: $telefono")
    }
}



class Trabajador(var sueldo:Double,tel:Long):Persona(tel)
{


    override fun devolver_Info(): String {
        return super.devolver_Info()+"Sueldo: $sueldo"
    }
}


fun main()
{
    //Invoca al constructor principal con el valor por defecto para el telefono
    var p:Persona=Persona()

    var p2:Persona=Persona("76452154F")
    var t:Trabajador=Trabajador(1500.toDouble(),983454545)
    var p4:Persona=Trabajador(2000.toDouble(),83223322)

    println(p4.devolver_Info())

   /* t.

    var p3:Persona=Persona("12422124R","luis",983454543)


    println("Dni: ${p3.dni} , Nombre:${p3.nombre}, Telefono:${p3.telefono}")

*/

    /*
    p.telefono
    p.nombre="luis"

    println(p.nombre)*/

}