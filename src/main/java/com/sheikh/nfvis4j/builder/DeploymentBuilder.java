package com.sheikh.nfvis4j.builder;

import com.sheikh.nfvis4j.model.EscDeployment;

/**
 * All Deployment builder will implement this interface.
 * Currently only implemented Class is EscDeploymentBuilder.
 * If any other VM Lifecycle manager is introduced then it only
 * need to implement this interface.
 * The build method usually resides on the implementing classes
 * if we don't know what type of object it's going to return.
 * One option is to use an interface as return type, but not all
 * deployments are going to have common interface
 * If we do know the type, i.e.  Deployment, we can just put it here.
 * Other option is using generic.
 * @author Sheikh Qumruzzaman
 * Sep 14, 2019
 */
public interface DeploymentBuilder {
	public DeploymentBuilder name(String name);
	public DeploymentBuilder image(String image);
	public DeploymentBuilder flavor(String flavor);
	public DeploymentBuilder network(String network);
	public DeploymentBuilder bootupTime(String bootupTime);
	//TODO Use generics
	public EscDeployment build();
}