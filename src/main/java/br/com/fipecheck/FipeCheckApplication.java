package br.com.fipecheck;

import br.com.fipecheck.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeCheckApplication implements CommandLineRunner {

	static void main(String[] args) {
		SpringApplication.run(FipeCheckApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibeMenu();
	}
}
