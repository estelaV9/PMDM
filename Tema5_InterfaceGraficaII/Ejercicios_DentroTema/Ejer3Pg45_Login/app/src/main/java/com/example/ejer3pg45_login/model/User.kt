package com.example.ejer3pg45_login.model

class User(val username: String, val password: String) {

    fun isValid(nameForm: String, passwordForm: String): Boolean {
        return nameForm == username && passwordForm == password
    } // METODO PARA VALIDAR LAS CREDENCIALES
}