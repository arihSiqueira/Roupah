package com.example.arihanemariano.roupah.model;

public class Teste {
	
	public static void main(String[] args){
		
		Sistema s = new Sistema();
		
		Usuario a = s.cadastrarUsuario("Arihane", "30/09/1994", "arihgatinha@ridicula.com", "abiaelegal");
		Usuario b = s.cadastrarUsuario("Beatriz", "22/07/1996", "email@email.com", "bialegal");

		System.out.println(s.logar("email@email.com", "bialegal"));
		
		GuardaRoupa roupasBia = b.abrirGuardaRoupa();
		GuardaRoupa roupasArih = a.abrirGuardaRoupa();
		roupasBia.addRoupa(new Roupa("c:\\imagem.txt","cal�a","verde","roupa legal"));
		roupasBia.addRoupa(new Roupa("", "vestido", "azul", "poxa divertido"));
		roupasBia.addRoupa(new Roupa("", "camisa", "azul", "poxa estranho"));
		roupasArih.addRoupa(new Roupa("c:\\magem.txt","vestido","preta","roupa feia"));
		
		
		for(Roupa r:roupasBia.mostrarRoupas()){
			System.out.println(r.getDescricao());
		}
		
		
		
		
	}

}
