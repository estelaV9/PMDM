package org.example

import Persona
import Trabajador

// DEFINICION DE LA CLASE
// ASIGNAS DIRECTAMENTE LOS ATRIBUTOS DE LA CLASE Vehiculo Y ESO CREA EL CONSTRUCTOR PRINCIPAL
class Vehiculo(var marcar:String, var modelo:String, var matricula:String) {

    lateinit var motor:String // LA PROPIEDAD MOTOR SE INICIALIZA MAS TARDE

    // CONSTRUCTOR SECUNDARIO QUE PERMITE CREAR UN Vehiculo CON MAS PARAMETROS
    constructor(mar:String, mod:String, mat:String, plazas:Int=0, motor:String)
            : this(mar, mod, mat){ // LLAMA AL CONSTRUCTOR PRIMARIO PARA INICIARLIZAR MARCA, MODELO Y MATRICULA
                    if(::motor.isInitialized) // NOS DEVUELVE UN VALOR BOOLEAN PARA SABER SI HA SIDO INICIALIZADO O NO
        this.motor = motor // ASIGNA EL VALOR DEL MOTOR A LA PROPIEDAD
    }

    fun arrancar(m:String){
        // VERIFICA SI EL MOTOR NO HA SIDO INICIALIZADO
        if(!::motor.isInitialized){
            this.motor=m // ASIGNA EL VALOR DE 'm' A LA PROPIEDAD 'motor'
        }
        println("Coche arrancado")
    } // FUNCION PARA ARRANCAR COCHE

}