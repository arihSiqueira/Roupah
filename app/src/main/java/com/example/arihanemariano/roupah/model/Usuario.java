package com.example.arihanemariano.roupah.model;


public class Usuario {
	String nome;
	String dataNasc;
	Login login;
	
	public Usuario(){}
	
	public Usuario(String n, String d, Login l){
		setNome(n);
		setDataNasc(d);
		setLogin(l);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public GuardaRoupa abrirGuardaRoupa(){
		GuardaRoupa g = new GuardaRoupa();
		return g;
	}
}
