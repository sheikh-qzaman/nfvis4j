package com.sheikh.nfvis4j.client;

import javax.ws.rs.HttpMethod;

import com.sheikh.nfvis4j.factory.NfvisResources;
import com.sheikh.nfvis4j.model.Deployment;
import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * This class uses a method and an inner class to do fluent style api
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
	
	public GetDeployment deployment(String deploymentName) {
		return new GetDeployment(deploymentName);
	}
	
	public class GetDeployment extends NfvisRequest<EscDeployment> {
		private String deploymentName;
		public GetDeployment(String deploymentName) {
			super(client, HttpMethod.GET, "/api/config/vm_lifecycle/tenants/tenant/admin/deployments/deployment/" + deploymentName, null, EscDeployment.class);
			this.deploymentName = deploymentName;
			// header and query param for this api. Client can always invoke the methods as builder chain to override or add new
			this.header("Accept", "application/vnd.yang.data+json");
			this.queryParam("deep", "");
		}
	}
	
	public Undeploy undeploy(String deploymentName) {
		return new Undeploy(deploymentName);
	}
	
	public class Undeploy extends NfvisRequest<Void> {
		public Undeploy(String deploymentName) {
			super(client, HttpMethod.DELETE, "/api/config/vm_lifecycle/tenants/tenant/admin/deployments/deployment/" + deploymentName, null, Void.class);
		}
	}
}
