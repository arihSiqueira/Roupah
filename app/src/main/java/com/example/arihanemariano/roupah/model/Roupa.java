package com.example.arihanemariano.roupah.model;

public class Roupa {
	String imagem;
	String tipo;
	String cor;
	String descricao;
	
	public Roupa(){}
	
	public Roupa(String i, String t, String c, String d){
		setCor(c);
		setDescricao(d);
		setImagem(i);
		setTipo(t);
	}
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
