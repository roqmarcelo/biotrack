package com.solutis.iot.hackaton.api;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.solutis.iot.hackaton.json.Aceleracao;
import com.solutis.iot.hackaton.service.AceleracaoService;
import com.solutis.iot.hackaton.service.LuminosidadeService;
import com.solutis.iot.hackaton.service.TemperaturaService;

@Path("/aplicacao")
public class Endpoint {

	@Inject
	private Instance<AceleracaoService> aceleracaoService;
	
	@Inject
	private Instance<LuminosidadeService> luminosidadeService;
	
	@Inject
	private Instance<TemperaturaService> temperaturaService;
	
	@GET
	@Path("/ping")
	public Response get() {
		return Response.ok("200 OK").build();
	}
	
	@POST
	@Path("/aceleracao")
	public void aceleracao(Aceleracao aceleracao) {
		aceleracaoService.get().processar(aceleracao);
	}
	
	@POST
	@Path("/luminosidade")
	public void luminosidade(String luminosidade) {
		luminosidadeService.get().processar(luminosidade);
	}
	
	@POST
	@Path("/temperatura")
	public void temperatura(String temperatura) {
		temperaturaService.get().processar(temperatura);
	}
}