package br.faccamp.domain;

public abstract class Operacao {

	private String n1;

	public abstract String calcula(String conteudo) ;

	public Operacao(String n1) {
		this.n1 = n1;
	}

	public String getN1() {
		return n1;
	}
}
