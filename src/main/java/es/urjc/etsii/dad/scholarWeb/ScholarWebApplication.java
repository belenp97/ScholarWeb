package es.urjc.etsii.dad.scholarWeb;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession
public class ScholarWebApplication{

	private static final Log LOG = LogFactory.getLog(ScholarWebApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ScholarWebApplication.class, args);
	}
	
	@Bean
	 public Config config() {
		 Config config = new Config();
		 JoinConfig joinConfig = config.getNetworkConfig().getJoin();
		 joinConfig.getMulticastConfig().setEnabled(false);
		 joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
		 return config;
	 }

	 @Bean
	 public CacheManager cacheManager() {
	    	LOG.info("Activating cache...");
	    	return new ConcurrentMapCacheManager("administrador");
	    }
	
}

