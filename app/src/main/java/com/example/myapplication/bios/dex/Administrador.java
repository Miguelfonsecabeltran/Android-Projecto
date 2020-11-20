package com.example.myapplication.bios.dex;

public class  Administrador extends Usuario {
    public Administrador(String correo, String nombre, String password, String rol) {
        super(correo, nombre, password, rol);
    }

    @Override
    public String getNombre() {
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }

    @Override
    public String getRol() {
        return super.getRol();
    }

    @Override
    public void setRol(String rol) {
        super.setRol(rol);
    }

    @Override
    public String getCorreo() {
        return super.getCorreo();
    }

    @Override
    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }
}
