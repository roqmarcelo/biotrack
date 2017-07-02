package com.solutis.iot.hackaton.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.solutis.iot.hackaton.json.Aceleracao;

@Stateless
public class AceleracaoService {

	@Inject
	private Instance<StorageService> storage;
	
	public void processar(Aceleracao aceleracao) {
		int aceleracaoX = (int) Math.ceil(Double.valueOf(aceleracao.getAceleracaoX().replace(',', '.')));
		int aceleracaoY = (int) Math.ceil(Double.valueOf(aceleracao.getAceleracaoY().replace(',', '.')));
		int aceleracaoZ = (int) Math.ceil(Double.valueOf(aceleracao.getAceleracaoZ().replace(',', '.')));

		if (aceleracaoX > 1 || aceleracaoY > 1 || aceleracaoZ > 2) {
			String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
			
			String log = data + " - Alerta de Impacto!";
			
			storage.get().gravarLog(log);
		}
	}
}