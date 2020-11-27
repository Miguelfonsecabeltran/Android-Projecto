package com.example.login.dex;

public class Administrador extends Usuario {

    //atributos heredados

    public Administrador(String correo, String nombre, String password, String rol) {
        super(correo, nombre, password, rol);
    }

    public String getNombre() {
        return super.getNombre();
    }

    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    public String getPassword() {
        return super.getPassword();
    }

    public void setPassword(String password) {
        super.setPassword(password);
    }

    public String getRol() {
        return super.getRol();
    }

    public void setRol(String rol) {
        super.setRol(rol);
    }

    public String getCorreo() {
        return super.getCorreo();
    }

    public void setCorreo(String correo) {
        super.setCorreo(correo);
    }

    public String registroAnimal(){



        return "";
    }

}
