package com.sheikh.nfvis4j.client;

import javax.ws.rs.HttpMethod;

import com.sheikh.nfvis4j.model.Deployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class ComputeResources {
	private final NfvisRestClient client;
	
	public ComputeResources(NfvisRestClient client) {
		this.client = client;
	}
	public Deploy deploy(Deployment deployment) {
		return new Deploy(deployment);
	}
	
	public class Deploy extends NfvisRequest<Deployment>{
		private Deployment deployment;
		
		public Deploy(Deployment deployment) {
			super(client, HttpMethod.POST, "/api/config/vm_lifecycle/tenants/tenant/admin/deployments", Entity.yjson(deployment), Deployment.class);
			this.deployment = deployment;
		}
	}
}
