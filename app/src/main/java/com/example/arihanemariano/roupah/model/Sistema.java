package com.example.arihanemariano.roupah.model;

import java.util.*;

public class Sistema {
	List<Usuario> usuarios = new ArrayList<Usuario>();;
	
	public Usuario cadastrarUsuario(String nome, String data, String email, String senha){
		Usuario u = new Usuario(nome, data, new Login(email, senha));
		usuarios.add(u);
		return u;
	}
	public String logar(String e, String s){
		for(Usuario u:usuarios){
			if(u.getLogin().matches(e, s)){
				return "Usuario logado";
			}
		}return "Usuario n�o conseguiu logar";
	}
}
