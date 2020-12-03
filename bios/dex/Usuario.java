package com.example.bios.dex;

import android.content.Intent;
import android.view.View;

import com.example.bios.MainActivity;
import com.example.bios.Register;

public class Usuario extends MainActivity{

    private String Correo;
    private String Nombre;
    private String Password;
    private String Rol;

    @Override
    public String toString() {
        return "Usuario{" +
                "Correo='" + Correo + '\'' +
                ", nombre='" + Nombre + '\'' +
                ", password='" + Password + '\'' +
                ", rol='" + Rol + '\'' +
                '}';
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        this.Rol = rol;
    }

    public Usuario(String correo, String nombre, String password, String rol) {
        this.Correo = correo;
        this.Nombre = nombre;
        this.Password = password;
        this.Rol = rol;
    }


}
