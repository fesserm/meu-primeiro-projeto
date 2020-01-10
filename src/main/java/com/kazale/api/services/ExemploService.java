package com.kazale.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kazale.api.entities.Empresa;
import com.kazale.api.repositories.EmpresaRepository;

@Service
public class ExemploService {
	
	@Autowired
	private EmpresaRepository empresaRepository;

	public void salvarEmpresa(Empresa empresa) {
		empresaRepository.save(empresa);
		System.out.println("Empresa : "+empresa.getRazaoSocial()+" salva com sucesso");
	}
	
	public Optional<Empresa> getEmpresaById(Long id) {
		Optional<Empresa> empresa = empresaRepository.findById(id);
		System.out.println("Buscou a empresa : "+empresa.get().getRazaoSocial());
		return empresa;
	}
}
