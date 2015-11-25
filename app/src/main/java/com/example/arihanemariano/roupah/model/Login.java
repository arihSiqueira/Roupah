package com.example.arihanemariano.roupah.model;


public class Login {
	String email;
	String senha;
	
	public Login(){}
	
	public Login(String e, String s){
		setEmail(e);
		setSenha(s);
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean matches(String e, String s){
		if(!(this.getEmail().equals(e)))
			return false;
		if(!(this.getSenha().equals(s)))
			return false;
		return true;
	}
	
}
