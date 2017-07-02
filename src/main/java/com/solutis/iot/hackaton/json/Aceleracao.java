package com.solutis.iot.hackaton.json;

import java.io.Serializable;

public class Aceleracao implements Serializable {

	private static final long serialVersionUID = -5335486227284425459L;

	private String aceleracaoX;
	
	private String aceleracaoY;
	
	private String aceleracaoZ;

	public String getAceleracaoX() {
		return aceleracaoX;
	}

	public void setAceleracaoX(String aceleracaoX) {
		this.aceleracaoX = aceleracaoX;
	}

	public String getAceleracaoY() {
		return aceleracaoY;
	}

	public void setAceleracaoY(String aceleracaoY) {
		this.aceleracaoY = aceleracaoY;
	}

	public String getAceleracaoZ() {
		return aceleracaoZ;
	}

	public void setAceleracaoZ(String aceleracaoZ) {
		this.aceleracaoZ = aceleracaoZ;
	}

	@Override
	public String toString() {
		return "Aceleracao [aceleracaoX=" + aceleracaoX + ", aceleracaoY=" + aceleracaoY + ", aceleracaoZ="
				+ aceleracaoZ + "]";
	}
}