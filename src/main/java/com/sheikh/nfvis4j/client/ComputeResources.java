package com.sheikh.nfvis4j.client;

import javax.ws.rs.HttpMethod;

import com.sheikh.nfvis4j.factory.NfvisResources;
import com.sheikh.nfvis4j.model.Deployment;
import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class ComputeResources implements NfvisResources{
	private final NfvisRestClient client;
	
	public ComputeResources(NfvisRestClient client) {
		this.client = client;
	}
	public Deploy deploy(Deployment deployment) {
		return new Deploy(deployment);
	}
	
	public class Deploy extends NfvisRequest<Void>{
		private Deployment deployment;
		
		public Deploy(Deployment deployment) {
			super(client, HttpMethod.POST, "/api/config/vm_lifecycle/tenants/tenant/admin/deployments", Entity.yjson(deployment), Void.class);
			this.deployment = deployment;
		}
	}
}
