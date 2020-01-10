package com.kazale.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kazale.api.entities.Empresa;
import com.kazale.api.repositories.EmpresaRepository;
import com.kazale.api.services.ExemploService;
import com.kazale.api.utils.SenhaUtils;

@SpringBootApplication
public class MeuPrimeiroProjetoApplication {
	
	@Value("${paginacao.qtd_por_pagina}")
	private String qtdPorPagina;
	
	
	@Autowired
	private ExemploService exemploService;

	public static void main(String[] args) {
		SpringApplication.run(MeuPrimeiroProjetoApplication.class, args); 
	}

//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return args -> {
////			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
////			System.out.println("Senha encoded : "+senhaEncoded);
////			
////			senhaEncoded = SenhaUtils.geraBCrypt("123456");
////			System.out.println("Senha encoded novamente : " + senhaEncoded);
////			
////			System.out.println("Senha válida : "+SenhaUtils.senhaValida("123456", senhaEncoded));
////			
//			Empresa empresa = new Empresa();
//			empresa.setRazaoSocial("Esser S.A");
//			empresa.setCnpj("0012269984552");
////			
////			this.empresaRepository.save(empresa);
////			
////			List<Empresa> empresas = empresaRepository.findAll();
////			empresas.forEach(System.out::println);
////			
////			Optional<Empresa> empresaDb = empresaRepository.findById(1L);
////			System.out.println("Empresa por ID :  "+empresaDb);
////			
////			Empresa empresaCnpj = empresaRepository.findByCnpj("0012269984552");
////			System.out.println("Empresa por CNPJ : " + empresaCnpj);
////			
////			this.empresaRepository.delete(empresaCnpj);
////			empresas = empresaRepository.findAll();
////			
////			System.out.println("Empresas: "+empresas.size());
////			
////			this.exemploService.testarService();
//			
//			exemploService.salvarEmpresa(empresa);
//			Long id = empresa.getId();
//			exemploService.getEmpresaById(id);
//		};
//	}
}
