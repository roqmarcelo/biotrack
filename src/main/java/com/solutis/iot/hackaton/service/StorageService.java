package com.solutis.iot.hackaton.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

import com.google.common.collect.Lists;

@Singleton
public class StorageService {
	
	private String temperaturaCaixa;
	
	private String estadoCaixa; // aberto ou fechado
	
	private boolean houveImpacto;
	
	private List<String> logs;
	
	@PostConstruct
	public void init() {
		houveImpacto = false;
		logs = new ArrayList<>();
	}

	public void gravarLog(String log) {
		logs.add(log);
	}
	
	public List<String> getLogs() {
		int index = 50;
		
		if (logs.size() < 50) {
			index = logs.size();
		}
		
		List<String> reverseLogs = Lists.reverse(logs);
		
		return Collections.unmodifiableList(reverseLogs.subList(0, index));
	}
	
	public void setTemperaturaCaixa(String temperaturaCaixa) {
		this.temperaturaCaixa = temperaturaCaixa;
	}
	
	public String getTemperaturaCaixa() {
		return temperaturaCaixa;
	}

	public void setEstadoCaixa(String estadoCaixa) {
		this.estadoCaixa = estadoCaixa;
	}
	
	public String getEstadoCaixa() {
		return estadoCaixa;
	}
	
	public void setHouveImpacto(boolean houveImpacto) {
		this.houveImpacto = houveImpacto;
	}
	
	public boolean getHouveImpacto() {
		return houveImpacto;
	}
}