package com.example.repasorecyclerview

import java.io.Serializable

// CREAMOS UN MODELO DE DATOS PARA CREAR EL LISTADO
// USAREMOS LAS DATA CLASES (parametros por defecto y devolvera los getter o setter)
data class SuperHero(
    val superHero: String,
    val publisher: String,
    val realName: String,
    val photo: String
) : Serializable
// PONEMOS SERIALIZABLE PARA QUE SE PUEDA CREAR EL PASAR LOS DATOS AL DIALOG