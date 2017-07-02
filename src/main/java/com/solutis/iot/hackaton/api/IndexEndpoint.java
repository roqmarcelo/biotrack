package com.solutis.iot.hackaton.api;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.solutis.iot.hackaton.json.IndexModel;
import com.solutis.iot.hackaton.service.StorageService;

@Path("/index")
public class IndexEndpoint {

	@Inject
	private Instance<StorageService> storage;
	
	@GET
	public Response get() {
		String estado = storage.get().getEstadoCaixa();
		String temperatura = storage.get().getTemperaturaCaixa();
		
		int valorTemperatura = (int)Math.ceil(Double.valueOf(temperatura.replace(',', '.')));
		
		IndexModel model = new IndexModel();
		model.setTexto(valorTemperatura + "° " + estado);
		
		if (valorTemperatura >= 25) {
			model.setCor("red");
		} else if (valorTemperatura >= 23) {
			model.setCor("yellow");
		} else {
			model.setCor("green");
		}
		
		return Response.ok(model, MediaType.APPLICATION_JSON_TYPE).build();
	}
}