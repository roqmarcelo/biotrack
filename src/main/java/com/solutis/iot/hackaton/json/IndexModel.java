package com.solutis.iot.hackaton.json;

import java.io.Serializable;

public class IndexModel implements Serializable {

	private static final long serialVersionUID = -6546660165391185341L;

	private String texto;
	
	private String cor;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}