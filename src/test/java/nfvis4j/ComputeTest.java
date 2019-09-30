package nfvis4j;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sheikh.nfvis4j.builder.Builders;
import com.sheikh.nfvis4j.client.Nfvis;
import com.sheikh.nfvis4j.model.Deployment;
import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * @author Sheikh Qumruzzaman
 * Sep 28, 2019
 */
public class ComputeTest {
	Nfvis nfvis = new Nfvis("https://192.168.0.222");
	String depName = "ROUTER";

	@Test
	public void deploy() {
		Deployment deployment = Builders.deployment()
				.name("ROUTER")
				.image("isrv-universalk9.16.08.01c-serial.tar.gz")
				.flavor("ISRv-small")
				.network("wan-net")
				.network("lan-net")
				.build();
		Object obj = nfvis.compute().deploy(deployment).execute();
		assertEquals(null, obj);
	}

	@Test
	public void getDeployment() {
		EscDeployment dep = nfvis.compute().deployment(depName).execute();
		assertEquals(dep.getName(), depName);
	}
	
	@Test
	public void undeploy() {
		Object obj = nfvis.compute().undeploy(depName).execute();
		assertEquals(1, 1);
	}
}
