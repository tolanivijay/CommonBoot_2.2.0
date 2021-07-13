package com.vijay;

import java.io.File;
import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

@Component
public class YAMlWriter {

	@Autowired
	private YAMLConfigs config;
	
	public void writeToDisk() {
		try {
			File f = new File("C:\\yamloutput\\test.yaml");
		    DumperOptions options = new DumperOptions();
		    options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
		    PrintWriter writer = new PrintWriter(f);
			Yaml yaml = new Yaml(options);
			yaml.dump(config.getMeta(), writer);
		}catch(Exception e) {
			System.out.println("Exception while Yaml WriteToDisk"+e);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		

	}

}
