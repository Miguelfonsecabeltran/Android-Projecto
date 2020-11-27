package com.example.bios.dex;

public class ArbolFilogenetico {

    private String nombrEspecieLatin;
    private String filo;
    private String clase;
    private String orden;
    private String familia;
    private String genero;

    public ArbolFilogenetico(){

    }

    public String getNombrEspecieLatin() {
        return nombrEspecieLatin;
    }

    public void setNombrEspecieLatin(String nombrEspecieLatin) {
        this.nombrEspecieLatin = nombrEspecieLatin;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
