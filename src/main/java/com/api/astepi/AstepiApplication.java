package com.api.astepi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EntityScan(basePackages = {
		"com.api.astepi.models"
})
@EnableJpaRepositories(basePackages = {
		"com.api.astepi.repositories"
})
public class AstepiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AstepiApplication.class, args);


	}

	@GetMapping("/")
	public String index(){
		return "Olá Mundo!";
	}

}
	/*public static void main(String[] args) {
		PessoaModel p1 = new PessoaModel();
		UsuarioModel u1 = new UsuarioModel();
		EnderecoModel e1 = new EnderecoModel();
		p1.setNome("Everson");
		p1.setCpf("089.123.456-78");
		//u1.getNaturalidade();
		//e1.("Rua do Príncipe");


		System.out.println("Qual é seu nome? " + p1.getNome());
		System.out.println("Qual o número do seu CPF? " + p1.getCpf());

		System.out.println("Qual nome da sua rua? " + e1.getRua());
		//System.out.println("Qual é sua nacionalodade ? " + u1.getNaturalidade()); // Só para mostrar que tá funcionando a associação da classe Cliente



	}*/


