package com.vijay;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "yamlproject")
public class YAMLConfigs {

	private Map<String,String> meta;
	
	private List<String> contributors;
	
	private List<AccountDetails> accountHolders;
	
	private Map<Integer,Boolean> activecheck;

	public Map<String, String> getMeta() {
		return meta;
	}

	public void setMeta(Map<String, String> meta) {
		this.meta = meta;
	}

	public List<String> getContributors() {
		return contributors;
	}

	public void setContributors(List<String> contributors) {
		this.contributors = contributors;
	}

	public List<AccountDetails> getAccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(List<AccountDetails> accountHolders) {
		this.accountHolders = accountHolders;
	}

	public Map<Integer, Boolean> getActivecheck() {
		return activecheck;
	}

	public void setActivecheck(Map<Integer, Boolean> activecheck) {
		this.activecheck = activecheck;
	}



	@Override
	public String toString() {
		return "YAMLConfigs [meta=" + meta + ", contributors=" + contributors + ", accountHolders=" + accountHolders
				+ ", activecheck=" + activecheck + "]";
	}

	
	
}
