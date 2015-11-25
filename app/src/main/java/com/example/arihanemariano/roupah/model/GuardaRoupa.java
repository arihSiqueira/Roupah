package com.example.arihanemariano.roupah.model;

import java.util.*;

public class GuardaRoupa {
	List<Roupa> roupas;
	int quantidade;
	
	public GuardaRoupa(){
		roupas = new ArrayList<Roupa>();
	}

	public List<Roupa> getLista(){		
		return roupas;
	}
	
	public void addRoupa(Roupa r){
		this.roupas.add(r);
	}
	
	public void removerRoupa(Roupa r){
		this.roupas.remove(r);
	}
	
	public List<Roupa> buscarRoupaCor(String r){
		List<Roupa> achados = new ArrayList<Roupa>();
		for(Roupa roupa:roupas){
			if(roupa.getCor().equals(r)){
				achados.add(roupa);				
			}
		}
		return achados;
	}
	
	public List<Roupa> mostrarRoupas(){
		List<Roupa> achados = new ArrayList<Roupa>();
		for(Roupa roupa:roupas){
			achados.add(roupa);		
		}
		return achados;
	}
}
