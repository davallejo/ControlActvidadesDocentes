package ec.uce.controlhorario;

import ec.uce.controlhorario.util.ViewScope;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class ControlhorarioWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlhorarioWebApplication.class, args);
	}

	@Bean
	public static ViewScope viewScope() {
		return new ViewScope();
	}

	@Bean
	public static CustomScopeConfigurer scopeConfigurer() {
		CustomScopeConfigurer configurer = new CustomScopeConfigurer();
		HashMap<String, Object> hashMap = new HashMap<>();
		hashMap.put("view", viewScope());
		configurer.setScopes(hashMap);
		return configurer;
	}
}
