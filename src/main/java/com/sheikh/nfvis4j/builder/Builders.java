package com.sheikh.nfvis4j.builder;

/**
 * @author Sheikh Qumruzzaman
 * Sep 14, 2019
 */
public class Builders {
	public static DeploymentBuilder deployment() {
		return new EscDeploymentBuilder();
	}
}
