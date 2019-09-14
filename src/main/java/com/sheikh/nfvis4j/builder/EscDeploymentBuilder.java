package com.sheikh.nfvis4j.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.sheikh.nfvis4j.model.Deployment;
import com.sheikh.nfvis4j.model.Deployment.VmGroup;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.ConfigData;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.ConfigData.Configuration;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.ConfigData.Configuration.Variable;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Interfaces;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Interfaces.Interface;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.KpiData;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.KpiData.Kpi;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.KpiData.Kpi.MetricCollector;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Placement;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.RecoveryPolicy;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Rules;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Rules.AdminRules;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Rules.AdminRules.Rule;
import com.sheikh.nfvis4j.model.Deployment.VmGroup.Scaling;
import com.sheikh.nfvis4j.model.Deployment.Vnc;

/**
 * @author Sheikh Qumruzzaman
 * Sep 14, 2019
 */
public class EscDeploymentBuilder implements DeploymentBuilder{
	private Deployment deployment;
	private VmGroup vmGroup;
	private Placement placement;
	private ConfigData configData;
	private Configuration configuration;
	private Interfaces interfaces;
	private List<Interface> interfaces_;
	private KpiData kpiData;
	private Kpi kpi;
	private RecoveryPolicy recoveryPolicy;
	private Rules rules;
	private AdminRules adminRules;
	private Rule rule;
	private Scaling scaling;
	private Vnc vnc;
	
	
	public EscDeploymentBuilder() {
		//this(new Deployment(), new Deployment.VmGroup());
		deployment = new Deployment();
		vmGroup = new Deployment.VmGroup();
		deployment.setVmGroup(Arrays.asList(vmGroup));
		placement = new VmGroup.Placement();
		vmGroup.setPlacement(placement);
		configData = new VmGroup.ConfigData();
		configuration = new ConfigData.Configuration();
		configuration.setVariable(Arrays.asList(new Variable()));
		configData.setConfiguration(Arrays.asList(configuration));
		vmGroup.setConfigData(configData);
		interfaces = new Interfaces();
		interfaces_ = new ArrayList<Interface>();
		// Add the default network for ESC management interface
		interfaces_.add(new Interface("0", "int-mgmt-net", null));
		interfaces.setInterfaces(interfaces_);
		vmGroup.setInterfaces(interfaces);
		kpiData = new KpiData();
		kpi = new Kpi();
		kpiData.setKpi(kpi);
		MetricCollector mc = new MetricCollector();
		kpiData.getKpi().setMetricCollector(mc);
		vmGroup.setKpiData(kpiData);
		scaling = new Scaling();
		vmGroup.setScaling(scaling);
		rules = new Rules();
		adminRules = new AdminRules();
		rule = new Rule();
		adminRules.setRule(rule);
		rules.setAdminRules(adminRules);
		vmGroup.setRules(rules);
		recoveryPolicy = new RecoveryPolicy();
		vmGroup.setRecoveryPolicy(recoveryPolicy);
		vnc = new Vnc();
		vmGroup.setVnc(vnc);
	}
	
	public EscDeploymentBuilder(Deployment deployment,
			Deployment.VmGroup vmGroup, Deployment.VmGroup.Placement placement) {
		this.deployment = deployment;
		this.vmGroup = vmGroup;
	}
	
	@Override
	public DeploymentBuilder name(String name) {
		deployment.setName(name);
		return this;
	}
	
	@Override
	public DeploymentBuilder image(String image) {
		vmGroup.setImage(image);
		return this;
	}
	
	@Override
	public DeploymentBuilder flavor(String flavor) {
		vmGroup.setFlavor(flavor);
		return this;
	}
	
	@Override
	public DeploymentBuilder bootupTime(String bootupTime) {
		vmGroup.setBootupTime(bootupTime);
		return this;
	}
	
	//@Override
	public DeploymentBuilder recoveryWaitTime(String time) {
		vmGroup.setRecoveryWaitTime(time);
		return this;
	}
	
	@Override
	public DeploymentBuilder network(String network) {
		Interface interface_ = new Interface();
		interface_.setNicId(Integer.toString(interfaces.getInterfaces().size()));
		interface_.setNetwork(network);
		interface_.setModel("virtio");
		interfaces.getInterfaces().add(interface_);
		return this;
	}
	
	//TODO Move this to super and use generics
	//@Override
	public Deployment build() {
		return deployment;
	}
}