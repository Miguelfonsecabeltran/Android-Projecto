package com.example.login.dex;

public class Investigador extends Usuario {
    public int puntaje;
    public int ranking;


    public Investigador(int puntaje, int ranking, String correo, String nombre, String password, String rol) {
        super(correo, nombre, password, rol);
        this.puntaje = puntaje;
        this.ranking = ranking;
    }



    public int getPuntaje() {
        return puntaje;
    }


    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }


    public int getRanking() {
        return ranking;
    }


    public void setRanking(int ranking) {
        this.ranking = ranking;
    }



	@Override
	public String login(String correo, String nombre, String password, String rol ) {
		// TODO Auto-generated method stub
		return null;
	}
}
