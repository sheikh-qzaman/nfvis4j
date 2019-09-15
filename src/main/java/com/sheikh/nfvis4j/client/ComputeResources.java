package com.sheikh.nfvis4j.client;

import javax.ws.rs.HttpMethod;

import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 11, 2019
 */
public class ComputeResources {
	private final NfvisRestClient client;
	
	public ComputeResources(NfvisRestClient client) {
		this.client = client;
	}
	public Deploy deploy(EscDeployment deployment) {
		return new Deploy(deployment);
	}
	
	public class Deploy extends NfvisRequest<EscDeployment>{
		private EscDeployment deployment;
		
		public Deploy(EscDeployment deployment) {
			super(client, HttpMethod.POST, "/api/config/vm_lifecycle/tenants/tenant/admin/deployments", Entity.yjson(deployment), EscDeployment.class);
			this.deployment = deployment;
		}
	}
}
