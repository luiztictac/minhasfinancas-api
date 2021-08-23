package br.com.luiztictac.minhasFinancas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableWebMvc //habilitar acesso as requisições
public class MinhasFinancasApplication implements WebMvcConfigurer {

	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE","OPTIONS" ); 
	} // /** é permitido para todos o acesso

	public static void main(String[] args) {
		SpringApplication.run(MinhasFinancasApplication.class, args);
	}

}
