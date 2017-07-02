package com.solutis.iot.hackaton.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Stateless
public class TemperaturaService {

	@Inject
	private Instance<StorageService> storage;
	
	public void processar(String temperatura) {
		String temperaturaAntiga = storage.get().getTemperaturaCaixa(); 
		
		int valorAntigo = temperaturaAntiga == null ? 0 : (int)Math.ceil(Double.valueOf(temperaturaAntiga.replace(',', '.')));
		int valorTemperatura = (int)Math.ceil(Double.valueOf(temperatura.replace(',', '.')));
		
		if (valorAntigo == 0 || valorAntigo != valorTemperatura) {
			storage.get().setTemperaturaCaixa(temperatura);
			
			String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

			String log = data + " - Temperatura da Caixa : " + valorTemperatura + "°";
			
			storage.get().gravarLog(log);
		}
	}
}