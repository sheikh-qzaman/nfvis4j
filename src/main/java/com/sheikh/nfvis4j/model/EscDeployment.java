package com.sheikh.nfvis4j.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

/**
 *TODO Replace the default values with appropriate constructs
 * @author Sheikh Qumruzzaman
 * Sep 9, 2019
 */
@JsonTypeInfo(include = As.WRAPPER_OBJECT, use = Id.NAME)
@JsonTypeName("vmlc:deployment")
@JsonInclude(Include.NON_NULL)
public class EscDeployment implements Deployment{
	private String name;
	
	@JsonProperty("vm_group")
	private List<VmGroup> vmGroup;
	private Vnc vnc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<VmGroup> getVmGroup() {
		return vmGroup;
	}
	public void setVmGroup(List<VmGroup> vmGroup) {
		this.vmGroup = vmGroup;
	}
	
	public static class VmGroup implements Serializable{
		private String name;
		@JsonProperty("vim_vm_name")
		private String vimVmName;
		private String image;
		private String flavor;
		@JsonProperty("bootup_time")
		private String bootupTime = "-1";
		@JsonProperty("recovery_wait_time")
		private String recoveryWaitTime = "5";
		private List<Placement> placement;
		@JsonProperty("recovery_policy")
		private RecoveryPolicy recoveryPolicy;
		private Interfaces interfaces;
		private Scaling scaling;
		@JsonProperty("kpi_data")
		private KpiData kpiData;
		private Rules rules;
		@JsonProperty("config_data")
		private ConfigData configData;
		private Vnc vnc;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getVimVmName() {
			return vimVmName;
		}
		public void setVimVmName(String vimVmName) {
			this.vimVmName = vimVmName;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getFlavor() {
			return flavor;
		}
		public void setFlavor(String flavor) {
			this.flavor = flavor;
		}
		public String getBootupTime() {
			return bootupTime;
		}
		public void setBootupTime(String bootupTime) {
			this.bootupTime = bootupTime;
		}
		public String getRecoveryWaitTime() {
			return recoveryWaitTime;
		}
		public void setRecoveryWaitTime(String recoveryWaitTime) {
			this.recoveryWaitTime = recoveryWaitTime;
		}
		public List<Placement> getPlacement() {
			return placement;
		}
		public void setPlacement(List<Placement> placement) {
			this.placement = placement;
		}
		public RecoveryPolicy getRecoveryPolicy() {
			return recoveryPolicy;
		}
		public void setRecoveryPolicy(RecoveryPolicy recoveryPolicy) {
			this.recoveryPolicy = recoveryPolicy;
		}
		public Interfaces getInterfaces() {
			return interfaces;
		}
		public void setInterfaces(Interfaces interfaces) {
			this.interfaces = interfaces;
		}
		public Scaling getScaling() {
			return scaling;
		}
		public void setScaling(Scaling scaling) {
			this.scaling = scaling;
		}
		public KpiData getKpiData() {
			return kpiData;
		}
		public void setKpiData(KpiData kpiData) {
			this.kpiData = kpiData;
		}
		public Rules getRules() {
			return rules;
		}
		public void setRules(Rules rules) {
			this.rules = rules;
		}
		public ConfigData getConfigData() {
			return configData;
		}
		public void setConfigData(ConfigData configData) {
			this.configData = configData;
		}
		public Vnc getVnc() {
			return vnc;
		}
		public void setVnc(Vnc vnc) {
			this.vnc = vnc;
		}
		
		public static class Placement implements Serializable {
			private String type = "zone_host";
			private String host = "datastore1";
			
			public String getType() {
				return type;
			}
			public void setType(String type) {
				this.type = type;
			}
			public String getHost() {
				return host;
			}
			public void setHost(String host) {
				this.host = host;
			}
		}
		
		public static class RecoveryPolicy implements Serializable{
			//TODO Create an enum for different actions
			@JsonProperty("action_on_recovery")
			private String actionOnRecovery = "REBOOT_ONLY";
		}
		
		public static class Interfaces implements Serializable{
			@JsonProperty("interface")
			private List<Interface> interfaces;
			
			public List<Interface> getInterfaces() {
				return interfaces;
			}

			public void setInterfaces(List<Interface> interfaces) {
				this.interfaces = interfaces;
			}

			@JsonInclude(Include.NON_NULL)
			public static class Interface implements Serializable{
				@JsonProperty("nicid")
				private String nicId;
				private String network;
				private String model;
				
				public Interface() {
				}
				
				public Interface(String nicid, String network, String model) {
					this.nicId = nicid;
					this.network = network;
					this.model = model;
				}
				
				public String getNicId() {
					return nicId;
				}
				public void setNicId(String nicId) {
					this.nicId = nicId;
				}
				public String getNetwork() {
					return network;
				}
				public void setNetwork(String network) {
					this.network = network;
				}
				public String getModel() {
					return model;
				}
				public void setModel(String model) {
					this.model = model;
				}
			}
		}
		public static class Scaling implements Serializable {
			@JsonProperty("min_active")
			private String minActive = "1";
			@JsonProperty("max_active")
			private String maxActive = "1";
			
			public String getMinActive() {
				return minActive;
			}
			public void setMinActive(String minActive) {
				this.minActive = minActive;
			}
			public String getMaxActive() {
				return maxActive;
			}
			public void setMaxActive(String maxActive) {
				this.maxActive = maxActive;
			}
		}
		
		public static class KpiData implements Serializable{
			//TODO Remove default values
			private List<Kpi> kpi;
			
			public List<Kpi> getKpi() {
				return kpi;
			}

			public void setKpi(List<Kpi> kpi) {
				this.kpi = kpi;
			}

			public static class Kpi implements Serializable{
				@JsonProperty("event_name")
				private String eventName = "VM_ALIVE";
				@JsonProperty("metric_value")
				private String metricValue = "1";
				@JsonProperty("metric_cond")
				private String metricCond = "GT";
				@JsonProperty("metric_type")
				private String metricType = "UINT32";
				@JsonProperty("metric_occurrences_false")
				private String metricOccurencesFalse = "60";
				@JsonProperty("metric_collector")
				private MetricCollector metricCollector;
				
				public String getEventName() {
					return eventName;
				}

				public void setEventName(String eventName) {
					this.eventName = eventName;
				}

				public String getMetricValue() {
					return metricValue;
				}

				public void setMetricValue(String metricValue) {
					this.metricValue = metricValue;
				}

				public String getMetricCond() {
					return metricCond;
				}

				public void setMetricCond(String metricCond) {
					this.metricCond = metricCond;
				}

				public String getMetricType() {
					return metricType;
				}

				public void setMetricType(String metricType) {
					this.metricType = metricType;
				}

				public String getMetricOccurencesFalse() {
					return metricOccurencesFalse;
				}

				public void setMetricOccurencesFalse(String metricOccurencesFalse) {
					this.metricOccurencesFalse = metricOccurencesFalse;
				}

				public MetricCollector getMetricCollector() {
					return metricCollector;
				}

				public void setMetricCollector(MetricCollector metricCollector) {
					this.metricCollector = metricCollector;
				}

				public static class MetricCollector implements Serializable{
					private String type = "ICMPPing";
					@JsonProperty("nicid")
					private String nicId = "0";
					@JsonProperty("poll_frequency")
					private String pollFrequency = "10";
					@JsonProperty("polling_unit")
					private String pollingUnit = "seconds";
					@JsonProperty("continuous_alarm")
					private String continuousAlarm = "false";
					
					public String getType() {
						return type;
					}
					public void setType(String type) {
						this.type = type;
					}
					public String getNicId() {
						return nicId;
					}
					public void setNicId(String nicId) {
						this.nicId = nicId;
					}
					public String getPollFrequency() {
						return pollFrequency;
					}
					public void setPollFrequency(String pollFrequency) {
						this.pollFrequency = pollFrequency;
					}
					public String getPollingUnit() {
						return pollingUnit;
					}
					public void setPollingUnit(String pollingUnit) {
						this.pollingUnit = pollingUnit;
					}
					public String isContinuousAlarm() {
						return continuousAlarm;
					}
					public void setContinuousAlarm(String continuousAlarm) {
						this.continuousAlarm = continuousAlarm;
					}
				}
			}
		}

		public static class Rules implements Serializable{
			@JsonProperty("admin_rules")
			private AdminRules adminRules;
			
			public AdminRules getAdminRules() {
				return adminRules;
			}

			public void setAdminRules(AdminRules adminRules) {
				this.adminRules = adminRules;
			}

			public static class AdminRules implements Serializable{
				private List<Rule> rule;
				
				public List<Rule> getRule() {
					return rule;
				}

				public void setRule(List<Rule> rule) {
					this.rule = rule;
				}

				public static class Rule implements Serializable{
					@JsonProperty("event_name")
					private String eventName = "VM_ALIVE";
					private List<String> action = new ArrayList<String>(
							Arrays.asList("ALWAYS log", "TRUE servicebooted.sh", "FALSE recover autohealing"));
					public String getEventName() {
						return eventName;
					}
					public void setEventName(String eventName) {
						this.eventName = eventName;
					}
					public List<String> getAction() {
						return action;
					}
					public void setAction(List<String> action) {
						this.action = action;
					}
				}
			}
		}

		public static class ConfigData implements Serializable{
			private List<Configuration> configuration;
			
			public List<Configuration> getConfiguration() {
				return configuration;
			}
			public void setConfiguration(List<Configuration> configuration) {
				this.configuration = configuration;
			}
			
			public static class Configuration implements Serializable{
				private String dst = "bootstrap_config";
				private List<Variable> variable;
				
				public String getDst() {
					return dst;
				}

				public void setDst(String dst) {
					this.dst = dst;
				}

				public List<Variable> getVariable() {
					return variable;
				}

				public void setVariable(List<Variable> variable) {
					this.variable = variable;
				}

				public static class Variable implements Serializable{
					private String name = "TECH_PACKAGE";
					private List<String> val = Arrays.asList("ax");
					
					public String getName() {
						return name;
					}
					public void setName(String name) {
						this.name = name;
					}
					public List<String> getVal() {
						return val;
					}
					public void setVal(List<String> val) {
						this.val = val;
					}
				}
			}
		}
	}
	
	@JsonIgnoreProperties
	public static class Vnc implements Serializable{

	}
}
