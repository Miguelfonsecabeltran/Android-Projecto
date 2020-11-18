package com.example.myapplication;

public class Usuario {
    private String Correo;
    private String nombre;
    private String password;
    private String rol;
    public Usuario(String correo, String nombre, String password, String rol) {
        super();
        this.Correo = correo;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
