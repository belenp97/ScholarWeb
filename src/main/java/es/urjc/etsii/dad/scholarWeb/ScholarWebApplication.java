package es.urjc.etsii.dad.scholarWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScholarWebApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(ScholarWebApplication.class, args);
	}
	
//	@Bean
//	 public Config config() {
//		 Config config = new Config();
//		 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
//		 joinConfig.getMulticastConfig().setEnabled(false);
//		 joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
//		 return config;
//	 }


	
}

