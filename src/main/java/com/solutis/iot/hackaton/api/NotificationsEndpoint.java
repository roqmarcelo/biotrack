package com.solutis.iot.hackaton.api;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.solutis.iot.hackaton.service.StorageService;

@Path("/notifications")
public class NotificationsEndpoint {

	@Inject
	private Instance<StorageService> storage;
	
	@GET
	public Response get() {
		return Response.ok(storage.get().getLogs(), MediaType.APPLICATION_JSON_TYPE).build();
	}
}