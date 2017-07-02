package com.solutis.iot.hackaton.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@Stateless
public class LuminosidadeService {

	@Inject
	private Instance<StorageService> storage;

	public void processar(String luminosidade) {
		double valorLuminosidade = Double.valueOf(luminosidade.replace(',', '.'));

		String estadoCaixa = valorLuminosidade == 0 ? "Fechada" : "Aberta";
		String estadoAntigo = storage.get().getEstadoCaixa();

		if (estadoAntigo == null || !estadoAntigo.equals(estadoCaixa)) {
			storage.get().setEstadoCaixa(estadoCaixa);

			String data = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());

			String log = data + " - Caixa " + estadoCaixa;

			storage.get().gravarLog(log);
		}
	}
}