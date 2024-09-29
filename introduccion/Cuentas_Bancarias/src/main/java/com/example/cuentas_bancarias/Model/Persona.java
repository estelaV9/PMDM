package com.example.cuentas_bancarias.Model;

import com.example.cuentas_bancarias.Interface.Imprimible;

public class Persona implements Imprimible {
    private String nombrePersona;
    private String apellidoPersona;
    private String dniPersona;

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
    public String toString() {
        return "Persona{" +
                "nombrePersona='" + nombrePersona + '\'' +
                ", apellidoPersona='" + apellidoPersona + '\'' +
                ", dniPersona='" + dniPersona + '\'' +
                '}';
    }

    @Override
    public String devolverInfoString() {
        return "Nombre: " + this.getNombrePersona() + " " + this.getApellidoPersona() +
                ". DNI: " + this.getDniPersona();
    }
}
