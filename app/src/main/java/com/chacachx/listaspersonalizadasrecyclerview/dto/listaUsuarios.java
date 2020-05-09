package com.chacachx.listaspersonalizadasrecyclerview.dto;

public class listaUsuarios {
    private String usuario, nombre, apellido, cuenta, imagen;

    public listaUsuarios(String usuario, String nombre, String apellido, String cuenta, String imagen) {
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuenta = cuenta;
        this.imagen = imagen;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCuenta() {
        return cuenta;
    }

    public String getImagen() {
        return imagen;
    }
}
