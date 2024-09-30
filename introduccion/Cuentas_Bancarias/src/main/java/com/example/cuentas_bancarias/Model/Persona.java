package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

public class Persona implements Imprimible {
    private String nombrePersona; // SE GUARDA EL NOMBRE DEL TITULAR
    private String apellidoPersona; // SE GUARDA EL APELLIDO DEL TITULAR
    private String dniPersona; // SE GUARDA EL DNI DEL TITULAR

    public Persona (){

    }
    public Persona(String nombrePersona, String apellidoPersona, String dniPersona) {
        this.nombrePersona = nombrePersona;
        this.apellidoPersona = apellidoPersona;
        this.dniPersona = dniPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getApellidoPersona() {
        return apellidoPersona;
    }

    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    public String getDniPersona() {
        return dniPersona;
    }

    public void setDniPersona(String dniPersona) {
        this.dniPersona = dniPersona;
    }

    @Override
    public String devolverInfoString() {
        return "Nombre: " + this.getNombrePersona() + " " + this.getApellidoPersona() +
                ". DNI: " + this.getDniPersona();
    } // METODO QUE DEVULVE LA INFORMACION DEL TITULAR
}
