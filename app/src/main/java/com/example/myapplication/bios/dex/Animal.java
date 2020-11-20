package com.example.myapplication.bios.dex;

public class Animal {

    private String nombreAnimal;
    private String estConservacion;
    private String evolucionAnterior;
    private String locacion;
    private double longitudAprox;
    private double pesoAprox;
    private String anatomia;
    private String diformismo;
    private String elementoBios;
    private String dieta;

    public Animal(String nombreAnimal, String estConservacion, String evolucionAnterior, String locacion, double longitudAprox, double pesoAprox, String anatomia, String diformismo, String elementoBios, String dieta) {
        this.nombreAnimal = nombreAnimal;
        this.estConservacion = estConservacion;
        this.evolucionAnterior = evolucionAnterior;
        this.locacion = locacion;
        this.longitudAprox = longitudAprox;
        this.pesoAprox = pesoAprox;
        this.anatomia = anatomia;
        this.diformismo = diformismo;
        this.elementoBios = elementoBios;
        this.dieta = dieta;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getEstConservacion() {
        return estConservacion;
    }

    public void setEstConservacion(String estConservacion) {
        this.estConservacion = estConservacion;
    }

    public String getEvolucionAnterior() {
        return evolucionAnterior;
    }

    public void setEvolucionAnterior(String evolucionAnterior) {
        this.evolucionAnterior = evolucionAnterior;
    }

    public String getLocacion() {
        return locacion;
    }

    public void setLocacion(String locacion) {
        this.locacion = locacion;
    }

    public double getLongitudAprox() {
        return longitudAprox;
    }

    public void setLongitudAprox(double longitudAprox) {
        this.longitudAprox = longitudAprox;
    }

    public double getPesoAprox() {
        return pesoAprox;
    }

    public void setPesoAprox(double pesoAprox) {
        this.pesoAprox = pesoAprox;
    }

    public String getAnatomia() {
        return anatomia;
    }

    public void setAnatomia(String anatomia) {
        this.anatomia = anatomia;
    }

    public String getDiformismo() {
        return diformismo;
    }

    public void setDiformismo(String diformismo) {
        this.diformismo = diformismo;
    }

    public String getElementoBios() {
        return elementoBios;
    }

    public void setElementoBios(String elementoBios) {
        this.elementoBios = elementoBios;
    }

    public String getDieta() {
        return dieta;
    }

    public void setDieta(String dieta) {
        this.dieta = dieta;
    }
}
